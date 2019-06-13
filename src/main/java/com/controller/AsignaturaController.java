package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Asignatura;
import com.service.AsignaturaService;

@RestController
@RequestMapping("/api/asignatura/")
public class AsignaturaController {
	@Autowired
	private AsignaturaService asignaturaService;

	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE} )
	public List<Asignatura> getAll(){
		return this.asignaturaService.getAllAsignaturas();
	}
	
	@GetMapping("/{id}")
	public Asignatura getAsignatura(@PathVariable("id") Long id) {
		return this.asignaturaService.findeOneAsignatura(id);
	}
}
