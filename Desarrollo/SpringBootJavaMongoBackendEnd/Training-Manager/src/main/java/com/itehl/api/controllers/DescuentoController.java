package com.itehl.api.controllers;

import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.itehl.api.service.IDescuentoService;
import com.itehl.api.model.Curso;
import com.itehl.api.model.Descuento;
import com.itehl.api.model.Modalidad;
import com.itehl.api.model.ResponseService;

@RestController
@RequestMapping("/rest/")
@CrossOrigin(origins = "http://localhost:4200/")
public class DescuentoController {
	
	private static final Logger logger = LoggerFactory.getLogger(DescuentoController.class);
	
	@Autowired
	private IDescuentoService iDescuentoervice; 
	
	

	@GetMapping("descuentos")
    public List<Descuento> listarDescuento(@RequestParam(name="idDescuento", required=false, defaultValue="") Long id) {
        return iDescuentoervice.listarDescuentos(id);
    }
	
	@GetMapping("descuento")
    public Descuento obtenerCurso(@RequestParam(name="idDescuento", required=false, defaultValue="") Long id) {
        return iDescuentoervice.listarDescuentos(id).get(0);
    }
	
	 @PutMapping(path="descuentos", produces = "application/json")
	    public ResponseService<Descuento> actualizarDescuento (@RequestBody Descuento descuento){
	    	ResponseService<Descuento> response = new ResponseService<Descuento>();
	    	
	    	Descuento c=iDescuentoervice.crearDescuento(descuento);
	    		response.setCodigo("200");
		    	response.setMessage("Modalidad actualizado exitosamente");
		    	
		    	 logger.debug("Modalidad actualizado exitosamente con Id " + c.getId());
			
	    	return response;
	    }
    
    
    @PostMapping(path="descuentos", produces = "application/json")
    public ResponseService<Descuento> crearDescuento (@RequestBody Descuento descuento){
    	ResponseService<Descuento> response = new ResponseService<Descuento>();
    	
    	Descuento c=iDescuentoervice.crearDescuento(descuento);
    		response.setCodigo("200");
	    	response.setMessage("Descuento creado exitosamente");
	    	
	    	 logger.debug("Descuento creado exitosamente con Id " + c.getId());
		
    	return response;
    }
    
    @DeleteMapping(path="descuentos", produces = "application/json")
    public ResponseService<Descuento> eliminarDescuento (@RequestParam(name="idDescuento", required=true, defaultValue="") Long idDescuento){
    	ResponseService<Descuento> response = new ResponseService<Descuento>();
    	List<Descuento> Descuento = iDescuentoervice.listarDescuentos(idDescuento);
    	Descuento c=null;
    	if(Descuento.size()>0) {
    		 c= Descuento.get(0);
    	}
    	
    	if(c!=null)
		{
    		iDescuentoervice.eliminarDescuento(idDescuento);
    		response.setCodigo("200");
	    	response.setMessage("Descuento eliminado exitosamente");
	    	
	    	logger.debug("Descuento creado eliminado con Id " + c.getId());
	    	
		}
    	else {
    		
    		
    		response.setCodigo("404");
	    	response.setMessage("Descuento no encontrado");	
    	}
    	return response;
    }


}
