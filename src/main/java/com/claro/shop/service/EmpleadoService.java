package com.claro.shop.service;

import java.util.List;

import com.claro.shop.model.Empleado;

public interface EmpleadoService {
    
	List<Empleado> obtenerTodosLosEmpleados();
    
    Empleado obtenerEmpleadoPorId(String id);
    
    Empleado crearEmpleado(Empleado empleado);
            
}
