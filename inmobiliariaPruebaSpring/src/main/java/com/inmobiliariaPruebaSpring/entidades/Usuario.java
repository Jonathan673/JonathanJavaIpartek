package com.inmobiliariaPruebaSpring.entidades;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@AllArgsConstructor
@Data
@SuperBuilder
public class Usuario {
	private Long id;
	@NotNull
	@Size(min = 3, max = 15)
	private String nombre;
	@NotNull
	@NotBlank
	@Email
	@Size(min = 3, max = 50)
	private String email;
	@NotNull
	@NotBlank
	@Size(min = 3, max = 15)
	private String password;
}
