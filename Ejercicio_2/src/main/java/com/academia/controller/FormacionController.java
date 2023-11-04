package com.academia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.academia.model.Formacion;
import com.academia.service.FormacionService;

@RestController
public class FormacionController {

	@Autowired
	FormacionService service;
	
	@GetMapping(value="formaciones",produces=MediaType.APPLICATION_JSON_VALUE)
	public List <Formacion> getAllFormaciones(){
		return service.getAllFormaciones();
	}
	
	@PostMapping(value="nueva-formacion",consumes=MediaType.APPLICATION_JSON_VALUE)
	public void newFormacion(@RequestBody Formacion formacion){
	
	service.newFormacion(formacion);
	}
}
