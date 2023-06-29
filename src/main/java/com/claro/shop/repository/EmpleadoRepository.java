package com.claro.shop.repository;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.claro.shop.model.Empleado;

public interface EmpleadoRepository extends MongoRepository<Empleado, String> {

	
	
}
