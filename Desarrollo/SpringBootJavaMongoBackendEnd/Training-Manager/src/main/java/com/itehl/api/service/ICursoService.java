package com.itehl.api.service;

import java.util.List;


import com.itehl.api.model.Curso;
import com.itehl.api.model.Modalidad;

public interface ICursoService {
		public abstract Curso crearCurso(Curso curso);
		public abstract void eliminarCurso(Long id);
		public abstract List<Curso> listarCursos(Long id);
		List<Curso> listarCursosPorModalidad(Modalidad idModalidad);
}
