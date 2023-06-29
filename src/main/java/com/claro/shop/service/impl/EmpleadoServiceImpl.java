package com.claro.shop.service.impl;

import org.springframework.stereotype.Service;

import com.claro.shop.model.Empleado;
import com.claro.shop.repository.EmpleadoRepository;
import com.claro.shop.service.EmpleadoService;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class EmpleadoServiceImpl implements EmpleadoService {
	
	private final EmpleadoRepository empleadoRepository;

    @Override
    public List<Empleado> obtenerTodosLosEmpleados() {
        return empleadoRepository.findAll();
    }

    @Override
    public Empleado obtenerEmpleadoPorId(String id) {
       return empleadoRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Empleado no encontrado con ID: " + id));   
    }

    @Override
    public Empleado crearEmpleado(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }    

    
}
