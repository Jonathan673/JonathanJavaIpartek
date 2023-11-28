package com.floristeria.globals;

//import com.floristeria.businesslogic.AdminNegocio;


public class Global {
	public static final Fabrica FABRICA = new FabricaImpl("C:/sqlite/floristeria.properties");
	
//	public static final UsuarioNegocio UN = FABRICA.obtenerUsuarioNegocio();
//	public static final AdminNegocio AN = FABRICA.obtenerAdminNegocio();
}
