package com.entity;

import java.io.Serializable;
import java.util.Date;

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
public class Examen implements Serializable{

	private static final long serialVersionUID = -1474498893735081799L;
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String titulo;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fecha; 

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_asignatura")
	private Asignatura asignatura;
	

	
	
	

}
