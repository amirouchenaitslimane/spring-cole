package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.Examen;

public interface ExamenRepository extends JpaRepository<Examen, Long> {

}
