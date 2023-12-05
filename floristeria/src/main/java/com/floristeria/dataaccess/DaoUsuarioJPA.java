package com.floristeria.dataaccess;


import com.floristeria.entities.Usuario;

public class DaoUsuarioJPA extends DaoJPA implements DaoUsuario {

	public DaoUsuarioJPA(String ignorado1, String ignorado2, String ignorado3) {
		super(ignorado1, ignorado2, ignorado3);
	}

	@Override
	public Usuario obtenerPorEmail(String email) {
		return (Usuario) transaccion(em -> em.find(Usuario.class, email));
	}

}
