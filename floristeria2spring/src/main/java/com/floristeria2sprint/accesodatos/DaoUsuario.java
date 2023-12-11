package com.floristeria2sprint.accesodatos;


import com.floristeria2sprint.entidades.Usuario;

public interface DaoUsuario extends Dao<Usuario> {
	Usuario obtenerPorEmail(String email);
}
