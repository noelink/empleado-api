package com.claro.shop.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.claro.shop.dto.ReporteNomina;
import com.claro.shop.service.EmpleadoService;
import com.claro.shop.utils.NominaOperations;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/nomina")
@RequiredArgsConstructor
public class NominaController {
	
	private final EmpleadoService empleadoService;

	@Operation(summary = "Ejecuta y muestra el calculo que se debe efectuar para la nomina de empleados, no se persiste solo se muestra cuanto se pagara en total segun el numero de empleados")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Ejecuta un reporte de nomina", content = {
			@Content(mediaType = "application/json", schema = @Schema(implementation = ReporteNomina.class)) }) })
    @GetMapping()
    public ReporteNomina obtenerEmpleadoPorId() {
        return NominaOperations.calculaSalarios(empleadoService.obtenerTodosLosEmpleados());
    }
}
