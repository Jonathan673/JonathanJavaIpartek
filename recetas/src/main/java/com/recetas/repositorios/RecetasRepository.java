package com.recetas.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.recetas.entidades.Receta;

@RepositoryRestResource(collectionResourceRel = "recetas", path = "recetas")
public interface RecetasRepository extends CrudRepository<Receta, Long>, 
											PagingAndSortingRepository<Receta, Long>{

}
