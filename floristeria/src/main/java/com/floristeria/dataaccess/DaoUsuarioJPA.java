package com.floristeria.dataaccess;


import com.floristeria.entities.Usuario;

public class DaoUsuarioJPA extends DaoJPA implements DaoUsuario {

	public DaoUsuarioJPA(String ignorado1, String ignorado2, String ignorado3) {
		super(ignorado1, ignorado2, ignorado3);
	}

	@Override
	public Usuario obtenerPorEmail(String email) {
		//return (Usuario) transaccion(em -> em.find(Usuario.class, email));
		
		//Quiero el usuario que, de la tabla usuarios, contenga el email que te paso. 
		//Me pasas el primer resultado y si no que sea nulo.
		return (Usuario) transaccion(em -> em.createQuery("from Usuario u where u.email = ?1", Usuario.class)
				.setParameter(1, email).getResultStream().findFirst().orElse(null));
	}

}
