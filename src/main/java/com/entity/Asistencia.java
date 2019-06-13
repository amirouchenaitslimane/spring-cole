package com.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Asistencia implements Serializable {

	private static final long serialVersionUID = 524849522761626072L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fecha;
	@Column(name = "enviado", nullable = false, columnDefinition = "boolean default false ")
	private Boolean enviado = false;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "alumno_id")
	private Alumno alumno;

}
