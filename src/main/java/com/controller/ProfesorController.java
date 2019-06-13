package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Asignatura;
import com.entity.Profesor;
import com.service.ProfesorService;

@RestController
@RequestMapping("/api/profesor/")
public class ProfesorController {
	@Autowired
	private ProfesorService profesorService;
	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE})
	public List<Profesor> getAll() {
		return this.profesorService.getAllProfesors();
	}
	
	@GetMapping("/{id}")
	public Profesor getAlumno(@PathVariable("id") long id) {
		return this.profesorService.findeOneProfesor(id);
	}
	
	@GetMapping("/{id}/asignaturas")
	public List<Asignatura> getProfesorAsignaturas(@PathVariable("id") long id) {
	return this.profesorService.getAsignaturasProfesor(id);
	
	}
	
	
	@PostMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseStatus(HttpStatus.CREATED)
	public Profesor addAlumno(@RequestBody final Profesor profesor) {
		return this.profesorService.saveOrUpdateProfesor(profesor);
	}
	@PutMapping("/{id}")
	public Profesor updateAlumno(@RequestBody final Profesor profesor, @PathVariable("id") Long id) {
		profesor.setId(id);
		return this.profesorService.saveOrUpdateProfesor(profesor);
	}
	
	@DeleteMapping("/{id}")	
	public void deleteAlumno(@PathVariable("id") Long id) {
		this.profesorService.deleteProfesor(id);		
	}
	
	
	
}
