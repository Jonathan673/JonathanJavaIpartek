package com.recetas.servicios;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.recetas.entidades.Receta;
import com.recetas.repositorios.RecetasRepository;

@Service
@Primary
public class LogicaAdminImplements implements LogicaAdmin{

	protected RecetasRepository recetasRepo;
	
	public LogicaAdminImplements(RecetasRepository repo) {
		this.recetasRepo = repo;
	}
	
	/**
	 * Lista todas las recetas
	 */
	@Override
	public Iterable<Receta> listarTodo() {
		return recetasRepo.findAll();
	}
	
	/**
	 * Guarda una nueva receta
	 */
	@Override
	public Receta insertar(Receta receta) {
		return recetasRepo.save(receta);
	}

}
