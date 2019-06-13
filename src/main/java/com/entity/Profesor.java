package com.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties({"asignaturas" ,"hibernateLazyInitializer", "handler"})
public class Profesor extends Persona implements Serializable {

	private static final long serialVersionUID = 5894916162634244854L;

	@ManyToMany
	@JoinTable(name = "profesor_asignatura", joinColumns = @JoinColumn(name = "id_profesor"), inverseJoinColumns = @JoinColumn(name = "id_asignatura"))
	List<Asignatura> asignaturas;
}
