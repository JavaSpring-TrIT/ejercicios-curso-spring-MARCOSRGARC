package com.academia.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.academia.model.Curso;

public interface CursoDao extends JpaRepository <Curso, Integer> {
	
	
	 @Query(value = "SELECT * from curso" +
		      " WHERE precio >= ?1 AND  precio <= ?2 ; ", nativeQuery = true)
		  List<Curso> findByprecio(int pMin, int pMax);

}