package edu.usal.negocio.dao.interfaces;

import java.sql.SQLException;

public interface I_LoginDAO {
	
	boolean vLogin(String usuario, String password) throws SQLException; 

}
