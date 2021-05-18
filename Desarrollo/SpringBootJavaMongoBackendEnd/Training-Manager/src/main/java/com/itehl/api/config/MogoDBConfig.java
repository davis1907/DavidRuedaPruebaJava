package com.itehl.api.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.itehl.api.model.Curso;
import com.itehl.api.model.Modalidad;
import com.itehl.api.repository.CursosRepository;
import com.itehl.api.repository.ModalidadRepository;

@EnableMongoRepositories(basePackageClasses = CursosRepository.class)
@Configuration
public class MogoDBConfig  {
	
	@Bean
	CommandLineRunner commandLineRunner(CursosRepository cursosRepository) {
		return strings -> {
		
			
			
			//cursosRepository.save(new Curso(1,"Matematicas1",3000D,"matematicas",60,"personas",null));
			//cursosRepository.save(new Curso(1,"Fisica",4000D,"fisyc",10,"personas",null));
		};
			
	}
	
	@Bean
	CommandLineRunner commandLineRunnerMod(ModalidadRepository modalidadRepository) {
		return strings -> {
		
			//modalidadRepository.save(new Modalidad(1,"Privado","Privado"));
		};
			
	}

}
