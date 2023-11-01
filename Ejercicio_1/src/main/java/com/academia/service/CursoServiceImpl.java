package com.academia.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.academia.dao.CursoDao;
import com.academia.model.Curso;

@Service
public class CursoServiceImpl implements CursoService{

	@Autowired
	CursoDao cursoDao;
	
	@Override
	public List<Curso> getAllcursos() {
		return cursoDao.findAll();
	}

	@Override
	public List<Curso> newCurso(Curso curso) {
		cursoDao.save(curso);
		return cursoDao.findAll();
	}

	@Override
	public List<Curso> deleteCurso(int Codcurso) {
		cursoDao.deleteById(Codcurso);
		return cursoDao.findAll();
	}

	@Override
	public void updateDuracion(int codCurso, int duracion) {
		
		Optional<Curso> cursoAModificar= cursoDao.findById(codCurso);
		
		if(cursoAModificar.isPresent()) {
			cursoAModificar.get().setDuracion(duracion);
			cursoDao.save(cursoAModificar.get());
		}
		
		
	}

	@Override
	public Curso buscarCurso(int codCurso) {
		return cursoDao.findById(codCurso).orElse(null);
	}

	@Override
	public List<Curso> buscarPorPrecio(int pMin, int pMax) {
		return cursoDao.findByprecio(pMin, pMax);
	}

}
