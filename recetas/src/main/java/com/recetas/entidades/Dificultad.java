package com.recetas.entidades;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name="dificultades")
public class Dificultad {
	public static final Dificultad RECETA = Dificultad.builder().id(3).build();
	
	@Id
//	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
//	@NotNull
	private String dificultad;
	
//	@ToString.Exclude
//	@EqualsAndHashCode.Exclude
//	@OneToMany(mappedBy = "dificultad")
//	private Set<Receta> recetas;
}
