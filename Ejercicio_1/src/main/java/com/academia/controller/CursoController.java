package com.academia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.academia.model.Curso;
import com.academia.service.CursoService;

@RestController
public class CursoController {
	
	@Autowired
	CursoService cursoService;
	
	@GetMapping (value="cursos",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Curso> getAllCursos(){
		return cursoService.getAllcursos();
	}

	@PostMapping(value="newcurso",consumes =MediaType.APPLICATION_JSON_VALUE)
	public void newCurso (@RequestBody Curso curso) {
		cursoService.newCurso(curso);
	}
	
	@DeleteMapping (value="deletecurso/{codCurso}",produces=MediaType.APPLICATION_JSON_VALUE) 
	public List<Curso> deleteCurso (@PathVariable int codCurso){
		return cursoService.deleteCurso(codCurso);
	}
	
	@PutMapping (value="updatecurso/{codCurso}/{duracion}") 
	public void updateDuracion (@PathVariable ("codCurso") int codCurso, @PathVariable ("duracion") int duracion) {
		cursoService.updateDuracion(codCurso, duracion);
	}
	
	@GetMapping(value="curso/{codCurso}")
	public Curso buscarCurso(@PathVariable ("codCurso") int codCurso){
		return cursoService.buscarCurso(codCurso);
	}
	
	@GetMapping(value="buscarcursoprecio/{pmin}/{pmax}")
	public List<Curso> findCursoPorPrecio (@PathVariable ("pmin") int pMin, @PathVariable ("pmax") int pMax) {
		return cursoService.buscarPorPrecio(pMin, pMax);
	}
		
	}
	
	
	
	
	
	
	
	
	
	
