package com.floristeria.globals;

import com.floristeria.businesslogic.AdminNegocio;
import com.floristeria.businesslogic.UsuarioNegocio;
import com.floristeria.dataaccess.DaoProducto;
import com.floristeria.dataaccess.DaoProveedor;
import com.floristeria.dataaccess.DaoUsuario;


public interface Fabrica {
	DaoProducto obtenerDaoProducto();
	DaoUsuario obtenerDaoUsuario();

	UsuarioNegocio obtenerUsuarioNegocio();
	AdminNegocio obtenerAdminNegocio();
	
	DaoProveedor obtenerDaoProveedor();
}
