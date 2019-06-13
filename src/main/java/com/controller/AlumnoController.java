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

import com.entity.Alumno;
import com.entity.Asignatura;
import com.entity.Asistencia;
import com.service.AlumnoService;

@RestController
@RequestMapping("/api/alumno/")
public class AlumnoController {
	@Autowired
	private AlumnoService alumnoService;

	
	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE} )
	public List<Alumno> getAll() {
		return this.alumnoService.getAllAlumnos();
	}
	
	@GetMapping("/{id}")
	public Alumno getAlumno(@PathVariable("id") long id) {
		return this.alumnoService.findeOneAlumno(id);
	}
	
	@GetMapping("/{id}/asignaturas")
	public List<Asignatura> getAlumnoAsignaturas(@PathVariable("id") long id) {
	return this.alumnoService.getAsignaturasAlumno(id);
	
	}
	@GetMapping("/{id}/asistencias")
	public List<Asistencia> getAlumnoExamenes(@PathVariable("id") long id) {
	return this.alumnoService.getAsistenciasAlumno(id);	
	}
	
	@PostMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseStatus(HttpStatus.CREATED)
	public Alumno addAlumno(@RequestBody final Alumno alumno) {
		return this.alumnoService.saveOrUpdateAlumno(alumno);
	}
	@PutMapping("/{id}")
	public Alumno updateAlumno(@RequestBody final Alumno alumno, @PathVariable("id") Long id) {
		alumno.setId(id);
		return this.alumnoService.saveOrUpdateAlumno(alumno);
	}
	
	@DeleteMapping("/{id}")	
	public void deleteAlumno(@PathVariable("id") Long id) {
		this.alumnoService.deleteAlumno(id);		
	}
	
	
	@GetMapping("/{id}/enviar")
	public String sendEmailAlumno() {
		return "enviado";
	}
}
