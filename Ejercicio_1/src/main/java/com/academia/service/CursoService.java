package com.academia.service;

import java.util.List;

import com.academia.model.Curso;

public interface CursoService {

	List <Curso> getAllcursos();
	List <Curso> newCurso(Curso curso);
	List <Curso> deleteCurso(int codCurso);
	void updateDuracion (int codCurso, int duracion);
	Curso buscarCurso(int codCurso);
	List <Curso> buscarPorPrecio (int pMin, int pMax);
	
	
}
