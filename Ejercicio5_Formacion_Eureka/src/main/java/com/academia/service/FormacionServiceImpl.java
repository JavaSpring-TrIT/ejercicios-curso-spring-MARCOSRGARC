package com.academia.service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.academia.model.Curso;
import com.academia.model.Formacion;

@Service
public class FormacionServiceImpl implements FormacionService {
	
	@Autowired
	RestTemplate template;
	
	private String url="http://localhost:8080/";

	@Override
	public List<Formacion> getAllFormaciones() {
		
		List<Formacion> formaciones =new ArrayList<Formacion>();
		
		
		List <Curso> cursos = Arrays.asList(template.getForObject(url+"cursos", Curso[].class));
		
		
		for (Curso curso : cursos) {
			
			int numeroAsignaturas;
			
			if(curso.getDuracion()>50) {
				numeroAsignaturas=10;
			}
			else {
				numeroAsignaturas=5;
			}
			formaciones.add(new Formacion(curso.getNombre(), numeroAsignaturas, curso.getPrecio()));
		}
		
		return formaciones;
	}

	@Override
	public void newFormacion(Formacion formacion) {
		
		List<Formacion> formaciones = getAllFormaciones();
		
		int horasPorAsignatura= 10;
		
		if (formaciones.stream()
					.filter(f->f.getNombreCurso().equals(formacion.getNombreCurso()))
					.findFirst()
					.orElse(null) != null) {
			
			// ya existe
		}else {
			// lo agregamos
			
			Curso curso = new Curso();
			curso.setDuracion(formacion.getNumeroAsignaturas()*horasPorAsignatura);
			curso.setNombre(formacion.getNombreCurso());
			curso.setPrecio(formacion.getPrecio());
			curso.setCodCurso(getCodigoCurso(formacion.getNombreCurso(),curso.getDuracion()));
			
			template.postForLocation(url+"newcurso", curso);
		}
		
		

	

	}
	
	private String getCodigoCurso (String nombre, int duracion) {
		
		return  nombre.substring(0, 3) + String.valueOf(duracion);
	}

}
