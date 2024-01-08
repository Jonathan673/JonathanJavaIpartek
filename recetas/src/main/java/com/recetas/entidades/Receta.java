package com.recetas.entidades;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Receta {
	@NotNull
	private Long id;
	@NotNull
	@Size(min = 3, max = 100)
	private String nombre;
	@NotNull
	private Long FK_dificultad;
}
