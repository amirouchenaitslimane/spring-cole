package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.entity.AlumnoExamen;
import com.entity.Examen;

public interface AlumnoExamenRepository extends JpaRepository<AlumnoExamen, Long> {

	
	List<AlumnoExamen> findByExamenId( Long id);

}
