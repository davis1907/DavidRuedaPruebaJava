package com.itehl.api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import com.itehl.api.model.Curso;
import com.itehl.api.model.Modalidad;
import com.itehl.api.repository.CursosRepository;
@Service
@PropertySource("classpath:application.properties")
public class CursoService implements ICursoService {

	@Autowired
	private CursosRepository cursosRepository;
	
	@Autowired
	private SequenceGeneratorService sequenceGeneratorService;
	
	@Override
	public Curso crearCurso(Curso curso) {		
		
		Curso resp=null;
		Optional<Curso> op =cursosRepository.findById(curso.getId());
		if(op.isPresent()) {
			resp=op.get();
			resp=this.cursosRepository.save(curso);
		}
		else {
			curso.setId(sequenceGeneratorService.generateSequence(Curso.SEQUENCE_NAME));
			resp=this.cursosRepository.save(curso);
		}
		
		return resp;
	}
	
	
	@Override
	public void eliminarCurso(Long id) {
		 this.cursosRepository.deleteById(id);
		
	}

	@Override
	public List<Curso> listarCursos(Long id) {
		List<Curso> servicioList = new ArrayList<Curso>();
		
		if(id!=null  ) {
			Optional<Curso> opCursos = this.cursosRepository.findById(id);
			
			servicioList.add(opCursos.get());
		}
		else {
			
			servicioList = this.cursosRepository.findAll();
			
		}
		
		return servicioList;
	}
	

	@Override
	public List<Curso> listarCursosPorModalidad(Modalidad idModalidad) {
		List<Curso> servicioList = new ArrayList<Curso>();
		
		if(idModalidad!=null  ) {
			servicioList = this.cursosRepository.findByModalidad(idModalidad);
			
			
		}
		else {
			
			servicioList = this.cursosRepository.findAll();
			
		}
		
		return servicioList;
	}


}
