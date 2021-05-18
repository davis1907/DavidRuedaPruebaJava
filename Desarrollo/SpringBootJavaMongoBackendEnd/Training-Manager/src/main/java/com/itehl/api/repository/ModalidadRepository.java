package com.itehl.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.itehl.api.model.Modalidad;


@Repository
public interface ModalidadRepository extends MongoRepository<Modalidad, Long> {

}
