package com.itehl.api.service;

import java.util.List;

import com.itehl.api.model.Modalidad;

public interface IModalidadService {
	public abstract Modalidad crearModalidad(Modalidad modalidad);
	public abstract void eliminarModalidad(Long id);
	public abstract List<Modalidad> listarModalidades(Long id);
}
