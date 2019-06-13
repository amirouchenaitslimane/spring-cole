package com.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import lombok.Data;

@Entity(name = "AlumnoExamen")
@Table(name = "alumno_examen")
@Data
public class AlumnoExamen implements Serializable {

	private static final long serialVersionUID = 7173052283140352070L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_alumno")
	private Alumno alumno;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_examen")
	private Examen examen;
	
	@Column(nullable = true)
	private Float nota;
	@Column(nullable = true)
	private String observacion;

}
