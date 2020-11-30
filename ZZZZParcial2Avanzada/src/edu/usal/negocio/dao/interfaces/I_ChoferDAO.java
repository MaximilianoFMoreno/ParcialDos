package edu.usal.negocio.dao.interfaces;

import java.sql.SQLException;

import edu.usal.negocio.dominio.Chofer;

public interface I_ChoferDAO {
	
	void altaChofer (Chofer chofer) throws SQLException; 
	void bajaChofer(int DNI) throws SQLException;
	void updateChofer(Chofer chofer);

}
