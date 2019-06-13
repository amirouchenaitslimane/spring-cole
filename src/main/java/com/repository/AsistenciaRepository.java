package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.Asistencia;

@Repository
public interface AsistenciaRepository  extends JpaRepository<Asistencia, Long>{

}
