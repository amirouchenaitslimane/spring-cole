package com.entity;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotBlank;

import lombok.Data;
@MappedSuperclass
@Data

public abstract class Persona implements Serializable {

	private static final long serialVersionUID = 8470542746367495683L;

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@NotBlank(message = "Dni del profesor es requerido")
	private String dni;
	@NotBlank(message = "nombre del profesor es requerido")
	private String nombre;
	private String apellido;
	private int edad;
	private int sexo;
	

}
