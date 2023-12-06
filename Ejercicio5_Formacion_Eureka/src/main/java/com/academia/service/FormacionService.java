package com.academia.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.academia.model.Formacion;


public interface FormacionService {
	
	List <Formacion> getAllFormaciones ();
	void newFormacion(Formacion formacion);

}
