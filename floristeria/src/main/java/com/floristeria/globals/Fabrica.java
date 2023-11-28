package com.floristeria.globals;

import com.floristeria.dataaccess.DaoProducto;


public interface Fabrica {
	DaoProducto obtenerDaoProducto();
//	DaoUsuario obtenerDaoUsuario();
//
//	UsuarioNegocio obtenerUsuarioNegocio();
//	AdminNegocio obtenerAdminNegocio();
}
