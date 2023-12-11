package com.floristeria2sprint.logicanegocio;

import org.springframework.stereotype.Component;

import com.floristeria2sprint.entidades.Producto;
import com.floristeria2sprint.entidades.Rol;

@Component
class AdminNegocioImpl extends UsuarioNegocioImpl implements AdminNegocio {

	@Override
	public Producto insertarProducto(Producto producto) {
		return daoProducto.insertar(producto);
	}

	@Override
	public Producto modificarProducto(Producto producto) {
		return daoProducto.modificar(producto);
	}

	@Override
	public void borrarProducto(Long id) {
		daoProducto.borrar(id);
	}

	@Override
	public Iterable<Rol> obtenerTodosLosRoles() {
		throw new LogicaNegocioException("NO IMPLEMENTADO");
	}

}
