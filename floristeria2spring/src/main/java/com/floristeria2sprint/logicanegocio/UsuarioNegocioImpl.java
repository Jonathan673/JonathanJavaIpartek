package com.floristeria2sprint.logicanegocio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.floristeria2sprint.accesodatos.DaoProducto;
import com.floristeria2sprint.entidades.Producto;
import com.floristeria2sprint.entidades.Usuario;

@Component
@Primary
class UsuarioNegocioImpl implements UsuarioNegocio {

	@Autowired
	protected DaoProducto daoProducto;

	@Override
	public Iterable<Producto> listadoProductos() {
		return daoProducto.obtenerTodos();
	}

	@Override
	public Producto detalleProducto(Long id) {
		return daoProducto.obtenerPorId(id);
	}

	@Override
	public Usuario loguear(String email, String password) {
		throw new LogicaNegocioException("NO IMPLEMENTADO");
	}

	@Override
	public long cuantosUsuariosHay() {
		throw new LogicaNegocioException("NO IMPLEMENTADO");
	}

	@Override
	public long cuantosProductosHay() {
		return daoProducto.cuantosHay();
	}
	
	
}
