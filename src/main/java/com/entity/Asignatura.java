package com.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@JsonIgnoreProperties({"alumnos","examenes" })
public class Asignatura implements Serializable {
	private static final long serialVersionUID = 7496728436777913075L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nombre;
	private String siglas;
	private int horasLectivas;
	
	@OneToMany(mappedBy = "asignatura")
    private List<Examen> examenes;
	
	@ManyToMany(mappedBy="asignaturas")
	List<Alumno> alumnos;

}
