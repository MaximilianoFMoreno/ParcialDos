package edu.usal.negocio.dao.interfaces;

import java.util.List;

import edu.usal.negocio.dominio.Camion;
import edu.usal.negocio.dominio.Viaje;

public interface I_ViajeDAO {
	
	List<Camion> altaViaje(int dni);
	void altaRealViaje(String dominio, String origen, String destino); 
	void updateViaje(Viaje viaje); 
	List<Viaje> listarViajes (int dni); 
	
	

}
