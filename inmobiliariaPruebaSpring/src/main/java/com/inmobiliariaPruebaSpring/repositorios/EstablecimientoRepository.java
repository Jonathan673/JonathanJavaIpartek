package com.inmobiliariaPruebaSpring.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.inmobiliariaPruebaSpring.entidades.Establecimiento;

@RepositoryRestResource(collectionResourceRel = "establecimientos", path = "establecimientos")
public interface EstablecimientoRepository extends CrudRepository<Establecimiento, Long>, 
													PagingAndSortingRepository<Establecimiento, Long>{
	
}
