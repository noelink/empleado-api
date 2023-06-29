package com.claro.shop.utils;

import java.time.LocalDateTime;
import java.util.List;

import com.claro.shop.dto.ReporteNomina;
import com.claro.shop.model.Empleado;

public class NominaOperations {

	public static ReporteNomina calculaSalarios(List<Empleado> empleados) {
		Long totalPagos = (long) empleados.size();
		Double totalPago = empleados.stream().mapToDouble(Empleado::getSalario).sum();
		return ReporteNomina.builder().cantidadDepositos(totalPagos).fechaReporte(LocalDateTime.now())
				.totalPago(totalPago).build();
	}

}
