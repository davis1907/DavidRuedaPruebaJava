package com.itehl.api.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.itehl.api.model.Curso;
import com.itehl.api.model.Modalidad;
@Repository
public interface CursosRepository extends MongoRepository<Curso, Long> {
  public abstract List<Curso> findByModalidad(Modalidad modalidad);
  
}
