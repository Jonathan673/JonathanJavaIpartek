package com.inmobiliariaPruebaSpring.entidades;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name = "establecimientos")
public class Establecimiento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	@Size(min = 2, max = 50)
	private String nombre;
	@NotNull
	@Size(min = 2, max = 100)
	private String ubicacion;
	@NotNull
	@Size(min = 2, max = 50)
	private String localidad;
	@NotNull
	@Size(min = 2, max = 50)
	private String tipo_establecimiento;
	@NotNull
	@Min(0)
	private BigDecimal precio;
}
