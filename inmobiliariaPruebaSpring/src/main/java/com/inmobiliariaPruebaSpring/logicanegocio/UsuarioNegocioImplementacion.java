package com.inmobiliariaPruebaSpring.logicanegocio;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.inmobiliariaPruebaSpring.entidades.Establecimiento;
import com.inmobiliariaPruebaSpring.repositorios.EstablecimientoRepository;

@Component
@Primary
public class UsuarioNegocioImplementacion implements UsuarioNegocio{
	
	protected EstablecimientoRepository establecimientoRepositorio;
	
	/**
	 * Indicamos el repositorio al que mirar
	 * @param repo
	 */
	public UsuarioNegocioImplementacion(EstablecimientoRepository repo) {
		this.establecimientoRepositorio = repo;
	}

	/**
	 * Lista todos los establecimientos disponibles en la base de datos
	 */
	@Override
	public Iterable<Establecimiento> obtenerTodos() {
		return establecimientoRepositorio.findAll();
	}
	
	/**
	 * Busca y lista el establecimiento seleccionado
	 */
	@Override
	public Establecimiento obtenerPorId(Long id) {
		return establecimientoRepositorio.findById(id).orElse(null);
	}

	/**
	 * Busca y lista los establecimientos segun el tipo de contrato
	 */
	@Override
	public Iterable<Establecimiento> obtenerPorTipoContrato(String contrato) {
		return null;
	}

}