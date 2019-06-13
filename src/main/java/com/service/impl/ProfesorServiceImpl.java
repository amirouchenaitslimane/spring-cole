package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Asignatura;
import com.entity.Profesor;
import com.repository.ProfesorRepository;
import com.service.ProfesorService;

@Service
public class ProfesorServiceImpl implements ProfesorService {

	@Autowired
	private ProfesorRepository repository;

	@Override
	public List<Profesor> getAllProfesors() {
		return this.repository.findAll();
	}

	@Override
	public Profesor saveOrUpdateProfesor(Profesor profesor) {
		if (profesor.getId() != null) {
			this.findeOneProfesor(profesor.getId());
		}
		return this.repository.save(profesor);
	}

	@Override
	public void deleteProfesor(Long idProfesor) {
		Profesor profesor = this.findeOneProfesor(idProfesor);
		this.repository.delete(profesor);

	}

	@Override
	public Profesor findeOneProfesor(Long idProfesor) {
		return this.repository.getOne(idProfesor);
	}

	@Override
	public List<Asignatura> getAsignaturasProfesor(Long idProfesor) {
		Profesor profesor = this.findeOneProfesor(idProfesor);
		return profesor.getAsignaturas();
	}

	
}
