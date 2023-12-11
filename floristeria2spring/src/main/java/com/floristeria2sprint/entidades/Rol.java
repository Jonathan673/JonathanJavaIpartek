package com.floristeria2sprint.entidades;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Rol {

	private Long id;
	private String nombre;

	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	private Set<Usuario> usuarios;

}
