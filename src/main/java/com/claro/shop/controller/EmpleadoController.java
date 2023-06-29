package com.claro.shop.controller;

import org.springframework.web.bind.annotation.*;

import com.claro.shop.model.Empleado;
import com.claro.shop.service.EmpleadoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RestController
@RequestMapping("/empleados")
@RequiredArgsConstructor
public class EmpleadoController {
    
    private final EmpleadoService empleadoService;

    @Operation(summary = "Crea un nuevo empleado")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Permite crear un nuevo empleado", content = {
			@Content(mediaType = "application/json", schema = @Schema(implementation = Empleado.class)) }) })
    @PostMapping
    public Empleado crearEmpleado(@RequestBody Empleado empleado) {
        return empleadoService.crearEmpleado(empleado);
    }
    
    @Operation(summary = "Consulta a un empleado por id")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Consulta un empleado por id", content = {
			@Content(mediaType = "application/json", schema = @Schema(implementation = Empleado.class)) }) })
    @GetMapping("/{id}")
    public Empleado obtenerEmpleadoPorId(@PathVariable("id") String id) {
        return empleadoService.obtenerEmpleadoPorId(id);
    }
    
    @Operation(summary = "Consulta todos los empleados existentes")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Consulta de empleados ejecutada con exito", content = {
			@Content(mediaType = "application/json", schema = @Schema(implementation = List.class)) }) })
    @GetMapping
    public List<Empleado> obtenerTodosLosEmpleados() {
        return empleadoService.obtenerTodosLosEmpleados();
    }

    

    
   
}
