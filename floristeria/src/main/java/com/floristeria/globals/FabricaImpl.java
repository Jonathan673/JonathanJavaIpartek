package com.floristeria.globals;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

import com.floristeria.businesslogic.AdminNegocio;
import com.floristeria.businesslogic.UsuarioNegocio;
import com.floristeria.dataaccess.DaoProducto;
import com.floristeria.dataaccess.DaoProveedor;
import com.floristeria.dataaccess.DaoUsuario;

public class FabricaImpl implements Fabrica {
	private final DaoProducto daoProducto;
	private final UsuarioNegocio usuarioNegocio;
	private final AdminNegocio adminNegocio;
	private final DaoUsuario daoUsuario;
	private final DaoProveedor daoProveedor;

	public FabricaImpl(String rutaFicheroProperties) {
		try {
			Properties props = new Properties();
			// lee el fichero de propiedades
			props.load(new FileReader(rutaFicheroProperties));

			// Para el accesoa datos de la base de datos, obtiene los datos del fichero que
			// le hemos pasado
			String tipoDaoUsuario = props.getProperty("accesodatos.tipo.usuario");
			String tipoDaoProducto = props.getProperty("accesodatos.tipo.producto");
			String tipoDaoProveedor = props.getProperty("accesodatos.tipo.proveedor");
			String url = props.getProperty("accesodatos.url");

			String user = props.getProperty("accesodatos.user");
			String pass = props.getProperty("accesodatos.pass");

			String tipoUsuarioNegocio = props.getProperty("logicanegocio.tipo.usuario");
			String tipoAdminNegocio = props.getProperty("logicanegocio.tipo.admin");

			daoProducto = (DaoProducto) Class.forName(tipoDaoProducto)
					.getDeclaredConstructor(String.class, String.class, String.class).newInstance(url, user, pass);
			daoUsuario = (DaoUsuario)Class.forName(tipoDaoUsuario).getDeclaredConstructor(String.class, String.class, String.class).newInstance(url, user, pass);

			Class<?> clase = Class.forName(tipoUsuarioNegocio);
			Constructor<?> constructor = clase.getConstructor();
			Object objeto = constructor.newInstance();
			usuarioNegocio = (UsuarioNegocio)objeto;

			adminNegocio = (AdminNegocio)Class.forName(tipoAdminNegocio).getDeclaredConstructor().newInstance();
			
			daoProveedor = (DaoProveedor) Class.forName(tipoDaoProveedor)
					.getDeclaredConstructor(String.class, String.class, String.class)
					.newInstance(url, user, pass);

		} catch (IOException | ClassNotFoundException | InstantiationException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
			throw new RuntimeException("No se ha podido leer el fichero de configuración: " + rutaFicheroProperties, e);
		}
	}

	@Override
	public DaoProducto obtenerDaoProducto() {
		return daoProducto;
	}

	@Override
	public UsuarioNegocio obtenerUsuarioNegocio() {
		return usuarioNegocio;
	}

	@Override
	public AdminNegocio obtenerAdminNegocio() {
		return adminNegocio;
	}

	@Override
	public DaoUsuario obtenerDaoUsuario() {
		return daoUsuario;
	}

	@Override
	public DaoProveedor obtenerDaoProveedor() {
		return daoProveedor;
	}

}
