package com.itehl.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.itehl.api.model.Descuento;


@Repository
public interface DescuentoRepository extends MongoRepository<Descuento, Long> {

}
