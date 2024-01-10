package com.recetas.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name="recetas")
public class Receta {
	@Id
//	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
//	@NotNull
	@Size(min = 3, max = 100)
	private String nombre;
//	@NotNull
//	private Long FK_dificultad;
//	@NotNull
//	@ManyToOne
//	@JoinColumn(name="FK_dificultad")
//	private Dificultad FK_dificultad;
	@ManyToOne
	@Builder.Default
	private Dificultad FK_dificultad = Dificultad.RECETA;
}
