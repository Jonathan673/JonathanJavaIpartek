package com.floristeria.entities;


import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class Usuario {
	private Long id;
	private String nombre;
	private String email;
	private String password;

	private Rol rol;
}
