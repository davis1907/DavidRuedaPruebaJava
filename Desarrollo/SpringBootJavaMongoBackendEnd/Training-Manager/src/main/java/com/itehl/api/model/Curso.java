package com.itehl.api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "cursos")
public class Curso {
 
	 @Transient
	 public static final String SEQUENCE_NAME = "cursos_sequence";
	
	@Id
	private Long id;	
	
	private String nombre;
    private Double costo;
    private String descripcion;
    private Integer horas;
    private String dirigidoA;
    private Modalidad modalidad;
    
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Double getCosto() {
		return costo;
	}
	public void setCosto(Double costo) {
		this.costo = costo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Integer getHoras() {
		return horas;
	}
	public void setHoras(Integer horas) {
		this.horas = horas;
	}
	public String getDirigidoA() {
		return dirigidoA;
	}
	public void setDirigidoA(String dirigidoA) {
		this.dirigidoA = dirigidoA;
	}
	public Modalidad getModalidad() {
		return modalidad;
	}
	public void setModalidad(Modalidad modalidad) {
		this.modalidad = modalidad;
	}
	public Curso(Long id, String nombre, Double costo, String descripcion, Integer horas, String dirigidoA,
			Modalidad modalidad) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.costo = costo;
		this.descripcion = descripcion;
		this.horas = horas;
		this.dirigidoA = dirigidoA;
		this.modalidad = modalidad;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
    
}
