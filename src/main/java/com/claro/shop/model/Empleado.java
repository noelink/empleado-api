package com.claro.shop.model;

import java.math.BigInteger;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

@Data
@Document(collection = "empleado")
public class Empleado {
	
	@Id
    private String id;
    private String nombre;
    private String apellidoMaterno;
    private String apellidoPaterno;
    private String cargo;
    private Double salario;
}