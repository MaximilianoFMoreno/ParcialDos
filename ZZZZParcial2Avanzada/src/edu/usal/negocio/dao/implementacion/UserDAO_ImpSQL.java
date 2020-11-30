package edu.usal.negocio.dao.implementacion;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import edu.usal.negocio.dao.interfaces.I_LoginDAO;
import edu.usal.util.Conexion;

public class UserDAO_ImpSQL implements I_LoginDAO{
	
	
	

	@Override
	public boolean vLogin(String usuario, String password) throws SQLException {
		
		String validarUser = "SELECT usuario, password FROM Users WHERE usuario = '"+usuario+"' AND password = '"+password+"' "; 
		
		Conexion objCon = new Conexion();
		Statement stm = null; 
		
		stm = objCon.conectar().createStatement();
		ResultSet r=stm.executeQuery(validarUser);
		int x = 0; 
		
		while(r.next()){
			x++; 
		}
		if (x==0) {
			System.out.println("No hay usuario");
			return false; 
			
		}else{
			System.out.println("Usuario Encontrado");
			return true; 
		}
	}

}
