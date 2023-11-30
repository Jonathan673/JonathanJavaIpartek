package com.floristeria.dataaccess;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.floristeria.entities.Proveedor;

public class DaoProveedorSqlite extends DaoSqlite<Proveedor> implements DaoProveedor{

	public DaoProveedorSqlite(String url, String user, String pass) {
		super(url);
	}

	@Override
	protected Proveedor filaAObjeto(ResultSet rs) throws SQLException {
		throw new AccesoDatosException("NO IMPLEMENTADO");
	}

	@Override
	protected void objetoAFila(Proveedor objeto, PreparedStatement pst) throws SQLException {
		throw new AccesoDatosException("NO IMPLEMENTADO");
	}

}
