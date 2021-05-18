package com.itehl.api.service;

import java.util.List;

import com.itehl.api.model.Descuento;

public interface IDescuentoService {
	public abstract Descuento crearDescuento(Descuento curso);
	public abstract void eliminarDescuento(Long id);
	public abstract List<Descuento> listarDescuentos(Long id);
}
