package com.floristeria.businesslogic;

import static com.floristeria.globals.Global.FABRICA;

import com.floristeria.entities.Producto;
import com.floristeria.entities.Usuario;

public class UsuarioNegocioImpl implements UsuarioNegocio {
	
	@Override
	public Iterable<Producto> listadoProductos() {
		return FABRICA.obtenerDaoProducto().ObtenerTodosLosProductos();
	}

	@Override
	public Producto detalleProducto(Long id) {
		return FABRICA.obtenerDaoProducto().ObtenerPorId(id);
	}

	@Override
	public Usuario loguear(String email, String password) {
		Usuario usuario = FABRICA.obtenerDaoUsuario().obtenerPorEmail(email);
		
		if(usuario != null && usuario.getPassword().equals(password)) {
			return usuario;
		}
		
		return null;
	}

}
