package com.service;

import java.util.List;

import com.entity.Alumno;
import com.entity.Asignatura;

public interface AsignaturaService {

	List<Asignatura> getAllAsignaturas();

	Asignatura findeOneAsignatura(Long idAsignatura);

	Asignatura saveOrUpdateAsignatura(Asignatura asignatura);

	void deleteAsignatura(Long idAsignatura);
	
	List<Alumno> getAlumnosAsignatura(Long idAsignatura);
	
}
