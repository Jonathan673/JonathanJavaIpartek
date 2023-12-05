package com.floristeria.dataaccess;

import com.floristeria.entities.Usuario;

public interface DaoUsuario extends Dao<Usuario> {
	Usuario obtenerPorEmail(String email);
}
