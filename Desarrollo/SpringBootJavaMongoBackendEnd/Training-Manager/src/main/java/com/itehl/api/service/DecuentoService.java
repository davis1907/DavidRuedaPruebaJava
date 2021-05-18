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
import com.itehl.api.repository.DescuentoRepository;
@Service
@PropertySource("classpath:application.properties")
public class DecuentoService implements IDescuentoService{

	@Autowired
	private SequenceGeneratorService sequenceGeneratorService;
	
	@Autowired
	private DescuentoRepository descuentoRepository;
	
	@Override
	public Descuento crearDescuento(Descuento descuento) {
		
		
		Descuento resp=null;
		Optional<Descuento> op =descuentoRepository.findById(descuento.getId());
		if(op.isPresent()) {
			resp=op.get();
			
			
			
			
			resp=this.descuentoRepository.save(descuento);
		}
		else {
		
		descuento.setId(sequenceGeneratorService.generateSequence(Descuento.SEQUENCE_NAME));
		resp =this.descuentoRepository.save(descuento);
		}
		
		return resp;
	}
	
	double calcularDescuento(Descuento descuento) {
		
		
		if(descuento.getCurso()!=null) {
			double valorCurso=descuento.getCurso().getCosto();
			Modalidad modalida = descuento.getModalidad();
			
			if(modalida.getNombre().equalsIgnoreCase("privada"))
			{
				descuento.setDescuento(valorCurso*0.90);
				
			}
			if(modalida.getNombre().equalsIgnoreCase("online"))
			{
				descuento.setDescuento(valorCurso*0.80);
				
			}
			if(modalida.getNombre().equalsIgnoreCase("ondemand"))
			{
				descuento.setDescuento(valorCurso*0.70);
				
			}
			
		}
		
		
		return 0;
	}

	@Override
	public void eliminarDescuento(Long id) {
		this.descuentoRepository.deleteById(id);
		
	}

	@Override
	public List<Descuento> listarDescuentos(Long id) {
		List<Descuento> servicioList = new ArrayList<Descuento>();
		
		if(id!=null ) {
			Optional<Descuento> opCursos = this.descuentoRepository.findById(id);
			
			servicioList.add(opCursos.get());
		}
		else {
			
			servicioList = this.descuentoRepository.findAll();
			
		}
		
		return servicioList;
	}

}
