package com.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(uniqueConstraints={@UniqueConstraint(columnNames={"dni"})})
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties({ "asistencias", "asignaturas" ,"hibernateLazyInitializer", "handler"})

public class Alumno extends Persona implements Serializable{
	private static final long serialVersionUID = 1163597981196050394L;

	private String contacto;
	
	@OneToMany(mappedBy = "alumno")
	List<Asistencia> asistencias;

	
	@ManyToMany
	@JoinTable(name = "alumno_asignatura", joinColumns = @JoinColumn(name = "id_alumno"), inverseJoinColumns = @JoinColumn(name = "id_asignatura"))
	List<Asignatura> asignaturas;
	


}
