package com.inmobiliariaPruebaSpring.logicanegocio;

import org.springframework.stereotype.Component;

import com.inmobiliariaPruebaSpring.entidades.Establecimiento;
import com.inmobiliariaPruebaSpring.repositorios.EstablecimientoRepository;

@Component
public class AdminNegocioImplementacion extends UsuarioNegocioImplementacion implements AdminNegocio{
	
	/**
	 * Indicamos el repositorio al que mirar, en este caso sera el repo del padre
	 * @param repo
	 */
	public AdminNegocioImplementacion(EstablecimientoRepository repo) {
		super(repo);
	}

	/**
	 * Guarda el nuevo establecimiento insertado.
	 */
	@Override
	public Establecimiento insertar(Establecimiento establecimiento) {
		return establecimientoRepositorio.save(establecimiento);
	}
	
	/**
	 * Guarda el establecimiento modificado.
	 */
	@Override
	public Establecimiento modificar(Establecimiento establecimiento) {
		return establecimientoRepositorio.save(establecimiento);
	}

	/**
	 * Elimina el establecimiento por la id
	 */
	@Override
	public void eliminar(Long id) {
		establecimientoRepositorio.deleteById(id);
	}
}
