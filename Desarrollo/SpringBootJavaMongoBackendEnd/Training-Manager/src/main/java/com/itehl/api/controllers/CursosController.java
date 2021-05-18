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


import com.itehl.api.service.ICursoService;

import com.itehl.api.model.Curso;
import com.itehl.api.model.ResponseService;
@RestController
@RequestMapping("/rest/")
@CrossOrigin(origins = "http://localhost:4200/")
public class CursosController {
	
	private static final Logger logger = LoggerFactory.getLogger(CursosController.class);
	
	@Autowired
	private ICursoService iCursoService; 
	
	

	@GetMapping("cursos")
    public List<Curso> listarCursos(@RequestParam(name="idCurso", required=false, defaultValue="") Long id) {
        return iCursoService.listarCursos(id);
    }
	
	@GetMapping("cursosPorModalidad")
    public List<Curso> listarCursosPorModalidad(@RequestParam(name="idModalidad", required=false, defaultValue="") Long id) {
        return iCursoService.listarCursos(id);
    }
    
	@GetMapping("curso")
    public Curso obtenerCurso(@RequestParam(name="idCurso", required=false, defaultValue="") Long id) {
        return iCursoService.listarCursos(id).get(0);
    }
    
    @PostMapping(path="cursos", produces = "application/json")
    public ResponseService<Curso> crearCurso (@RequestBody Curso curso){
    	ResponseService<Curso> response = new ResponseService<Curso>();
    	
    		Curso c=iCursoService.crearCurso(curso);
    		response.setCodigo("200");
	    	response.setMessage("Curso creado exitosamente");
	    	
	    	 logger.debug("Curso creado exitosamente con Id " + c.getId());
		
    	return response;
    }
    
    
    @PutMapping(path="cursos", produces = "application/json")
    public ResponseService<Curso> actualizarCurso (@RequestBody Curso curso){
    	ResponseService<Curso> response = new ResponseService<Curso>();
    	
    		Curso c=iCursoService.crearCurso(curso);
    		response.setCodigo("200");
	    	response.setMessage("Curso actualizado exitosamente");
	    	
	    	 logger.debug("Curso actualizado exitosamente con Id " + c.getId());
		
    	return response;
    }
    
    
    @DeleteMapping(path="cursos", produces = "application/json")
    public ResponseService<Curso> eliminarCurso (@RequestParam(name="idCurso", required=true, defaultValue="") Long idCurso){
    	ResponseService<Curso> response = new ResponseService<Curso>();
    	List<Curso> cursos = iCursoService.listarCursos(idCurso);
    	Curso c=null;
    	if(cursos.size()>0) {
    		 c= cursos.get(0);
    	}
    	
    	if(c!=null)
		{
    		iCursoService.eliminarCurso(idCurso);
    		response.setCodigo("200");
	    	response.setMessage("Curso eliminado exitosamente");
	    	
	    	logger.debug("Curso creado eliminado con Id " + c.getId());
	    	
		}
    	else {
    		
    		
    		response.setCodigo("404");
	    	response.setMessage("Curso no encontrado");	
    	}
    	return response;
    }


}
