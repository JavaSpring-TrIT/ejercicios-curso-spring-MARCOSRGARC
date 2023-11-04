package com.academia.service;

import java.util.List;

import com.academia.model.Curso;

public interface CursoService {

	List <Curso> getAllcursos();
	List <Curso> newCurso(Curso curso);
	List <Curso> deleteCurso(String codCurso);
	void updateDuracion (String codCurso, int duracion);
	Curso buscarCurso(String codCurso);
	List <Curso> buscarPorPrecio (int pMin, int pMax);
	
	
}
