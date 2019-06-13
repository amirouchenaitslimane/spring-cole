package com.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Alumno;
import com.entity.Asignatura;
import com.repository.AsignaturaRepository;
import com.service.AsignaturaService;



@Service
public class AsignaturaServiceImpl implements AsignaturaService {
	@Autowired
	private AsignaturaRepository repository;

	@Override
	public List<Asignatura> getAllAsignaturas() {
		return this.repository.findAll();
	}

	@Override
	public Asignatura findeOneAsignatura(Long idAsignatura) {
		Optional<Asignatura> asignatura = this.repository.findById(idAsignatura);
		
		return asignatura.get();
	}

	@Override
	public Asignatura saveOrUpdateAsignatura(Asignatura asignatura) {
		if (asignatura.getId() != null) {
			this.findeOneAsignatura(asignatura.getId());
		}
		return this.repository.save(asignatura);
	}

	@Override
	public void deleteAsignatura(Long idAsignatura) {
		Asignatura asignatura = this.findeOneAsignatura(idAsignatura);
		this.repository.delete(asignatura);

	}

	@Override
	public List<Alumno> getAlumnosAsignatura(Long idAsignatura) {
		Asignatura asignatura = this.findeOneAsignatura(idAsignatura);
		return asignatura.getAlumnos();
	}

}
