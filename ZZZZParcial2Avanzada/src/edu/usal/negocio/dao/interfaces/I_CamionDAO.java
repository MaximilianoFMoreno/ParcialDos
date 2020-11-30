package edu.usal.negocio.dao.interfaces;

import java.sql.SQLException;

import edu.usal.negocio.dominio.Camion;

public interface I_CamionDAO {
	
	void altaCamion(Camion camion) throws SQLException; 
	void bajaCamion(String dominio); 
	void updateCamion(Camion camion); 
	

}
