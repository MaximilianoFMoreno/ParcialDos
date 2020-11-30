
package edu.usal.main;

import java.sql.SQLException;
import java.util.List;

import edu.usal.negocio.dao.implementacion.CamionDAO_ImpSQL;
import edu.usal.negocio.dao.implementacion.ChoferDAO_ImpSQL;
import edu.usal.negocio.dao.implementacion.ViajeDAO_ImpSQL;
import edu.usal.negocio.dominio.Camion;
import edu.usal.negocio.dominio.Chofer;
import edu.usal.negocio.dominio.Viaje;
import edu.usal.util.Conexion;

public class Main {

	public static void main(String[] args) throws SQLException {
		
	Conexion objCon = new Conexion(); 		
	System.out.println(objCon.conectar());
	
	CamionDAO_ImpSQL kmi =  new CamionDAO_ImpSQL(); 
	Camion cami = new Camion(); 
	kmi.bajaCamion("BBB");
	
	/*
	Viaje viajesito = new Viaje(); 
	ViajeDAO_ImpSQL vjj = new ViajeDAO_ImpSQL();
	viajesito.setViajeID(2);
	viajesito.setEstado(1);
	vjj.updateViaje(viajesito);
	*/
	
	/*
	ChoferDAO_ImpSQL chof = new ChoferDAO_ImpSQL();
	
	Chofer cf = new Chofer(); 
	
	
	cf.setNombre("A");
	cf.setApellido("B");
	cf.setDni(1);
	cf.setFehca_nacimiento("C");
	cf.setNro_telefono("D");
	cf.setUsuario_chofer("PEPE");
	cf.setContraseña_chofer("peron");
	cf.setId_categoria("A1");
	
	*/ 
	
	/*
	cf.setDni(1);
	cf.setNro_telefono("2");
	*/
	
	//cf.setDni(1);
	
	// PRUEBAS
	//chof.altaChofer(cf);
	//chof.updateChofer(cf);
	//chof.bajaChofer(1);
	
/*
	ViajeDAO_ImpSQL vj = new ViajeDAO_ImpSQL(); 
	Chofer cf = new Chofer();
	cf.setDni(1);
	Camion cm = new Camion(); 
	cm.setCategoria("A1");
	
	//vj.altaViaje(cf.getDni());
	//vj.altaViaje(cf);
	
	List<Camion> c = vj.altaViaje(6); 
	
	for (Camion camion : c) {
		System.out.println(camion.toString());
	}
	
	
	vj.altaRealViaje("AAA","CABA","Cordoba");
	
	*/
	
	}
	

}


