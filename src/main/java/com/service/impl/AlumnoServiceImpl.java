package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Alumno;
import com.entity.Asignatura;
import com.entity.Asistencia;
import com.entity.Examen;
import com.repository.AlumnoRepository;
import com.service.AlumnoService;

@Service
public class AlumnoServiceImpl implements AlumnoService {

	@Autowired
	private AlumnoRepository repository;

	@Override
	public List<Alumno> getAllAlumnos() {
		return this.repository.findAll();
	}

	@Override
	public Alumno saveOrUpdateAlumno(Alumno alumno) {
		if (alumno.getId() != null) {
			this.findeOneAlumno(alumno.getId());
		}
		return this.repository.save(alumno);

	}

	@Override
	public void deleteAlumno(Long id) {
		Alumno alumno = this.findeOneAlumno(id);
		this.repository.delete(alumno);
	}

	@Override
	public Alumno findeOneAlumno(Long id) {
		return repository.getOne(id);
	}

	@Override
	public List<Asignatura> getAsignaturasAlumno(Long idAlumno) {
	Alumno a = this.findeOneAlumno(idAlumno);
	List<Asignatura> asignaturas = a.getAsignaturas();
	return asignaturas;
	}

	@Override
	public List<Asistencia> getAsistenciasAlumno(long idAlumno) {
		Alumno a = this.findeOneAlumno(idAlumno);
		return a.getAsistencias();
	}

	@Override
	public boolean sendEmail() {
		// TODO Auto-generated method stub
		return false;
	}

	

}
