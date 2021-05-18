package com.itehl.api.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
@Document
public class Descuento {
	
	@Transient
	 public static final String SEQUENCE_NAME = "descuentos_sequence";
	
	@Id
	private Long id;	
	private String nombre;
	private double descuento;
	private Modalidad modalidad;
	private String pais;
	private Curso curso;
	private Date fechafinal;
	public String getNombre() {
		return nombre;
	}
	
	public double getDescuento() {
		return descuento;
	}
	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}
	public Modalidad getModalidad() {
		return modalidad;
	}

	public void setModalidad(Modalidad modalidad) {
		this.modalidad = modalidad;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public Curso getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	public Date getFechafinal() {
		return fechafinal;
	}
	public void setFechafinal(Date fechafinal) {
		this.fechafinal = fechafinal;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Descuento(Long id, String nombre, double descuento, Modalidad modalidad, String pais, Curso curso,
			Date fechafinal) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descuento = descuento;
		this.modalidad = modalidad;
		this.pais = pais;
		this.curso = curso;
		this.fechafinal = fechafinal;
	}
	
	
	
}
