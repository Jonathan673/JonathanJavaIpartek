package com.floristeria.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "usuarios")
public class Usuario {
	@Id
	private Long id;
	private String nombre;
	private String email;
	private String password;
	
	@NotNull
	@ManyToOne
	private Rol rol;
}
