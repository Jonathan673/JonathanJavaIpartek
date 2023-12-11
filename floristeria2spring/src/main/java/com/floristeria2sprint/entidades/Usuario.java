package com.floristeria2sprint.entidades;


import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Usuario {

	private Long id;
	private String nombre;
	private String email;
	private String password;
	
	@NotNull
	private Rol rol;
}
