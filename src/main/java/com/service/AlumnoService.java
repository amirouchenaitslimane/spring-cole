package com.service;

import java.util.List;

import com.entity.Alumno;
import com.entity.Asignatura;
import com.entity.Asistencia;
import com.entity.Examen;

public interface AlumnoService {
	List<Alumno> getAllAlumnos();

	Alumno saveOrUpdateAlumno(Alumno a);

	void deleteAlumno(Long id);

	Alumno findeOneAlumno(Long id);
	
	List<Asignatura> getAsignaturasAlumno(Long idAlumno);

	List<Asistencia> getAsistenciasAlumno(long idAlumno);
	boolean sendEmail();
	
}
