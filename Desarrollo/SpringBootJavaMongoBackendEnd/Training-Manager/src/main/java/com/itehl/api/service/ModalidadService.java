package com.itehl.api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import com.itehl.api.model.Curso;
import com.itehl.api.model.Descuento;
import com.itehl.api.model.Modalidad;

import com.itehl.api.repository.ModalidadRepository;
@Service
@PropertySource("classpath:application.properties")
public class ModalidadService implements IModalidadService {

	@Autowired
	private SequenceGeneratorService sequenceGeneratorService;
	
	@Autowired
	private ModalidadRepository modalidadRepository;
	
	@Override
	public Modalidad crearModalidad(Modalidad modalidad) {
		
		Modalidad resp=null;
		Optional<Modalidad> op =modalidadRepository.findById(modalidad.getId());
		if(op.isPresent()) {
			resp=op.get();
			resp=this.modalidadRepository.save(modalidad);
		}
		else {
		modalidad.setId(sequenceGeneratorService.generateSequence(Modalidad.SEQUENCE_NAME));
		resp =this.modalidadRepository.save(modalidad);
		}
		return resp;
	}

	@Override
	public void eliminarModalidad(Long id) {
		this.modalidadRepository.deleteById(id);
		
	}

	@Override
	public List<Modalidad> listarModalidades(Long id) {
		List<Modalidad> servicioList = new ArrayList<Modalidad>();
		
		if(id!=null ) {
			Optional<Modalidad> opCursos = this.modalidadRepository.findById(id);
			
			servicioList.add(opCursos.get());
		}
		else {
			
			servicioList = this.modalidadRepository.findAll();
			
		}
		
		return servicioList;
	}

}
