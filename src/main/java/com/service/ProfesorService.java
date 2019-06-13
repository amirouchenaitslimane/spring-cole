package com.service;

import java.util.List;

import com.entity.Profesor;
import com.entity.Asignatura;
import com.entity.Asistencia;

public interface ProfesorService {
	List<Profesor> getAllProfesors();

	Profesor saveOrUpdateProfesor(Profesor profesor);

	void deleteProfesor(Long idProfesor);

	Profesor findeOneProfesor(Long idProfesor);

	List<Asignatura> getAsignaturasProfesor(Long idProfesor);

	

}
