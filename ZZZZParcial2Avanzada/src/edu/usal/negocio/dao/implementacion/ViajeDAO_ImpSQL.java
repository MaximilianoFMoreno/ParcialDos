package edu.usal.negocio.dao.implementacion;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.usal.negocio.dao.interfaces.I_ChoferDAO;
import edu.usal.negocio.dao.interfaces.I_ViajeDAO;
import edu.usal.negocio.dominio.Camion;
import edu.usal.negocio.dominio.Chofer;
import edu.usal.negocio.dominio.Viaje;
import edu.usal.util.Conexion;

public class ViajeDAO_ImpSQL implements I_ViajeDAO{
	
	Chofer chofer = new Chofer(); 
//	private static final String getChofer = "SELECT * FROM Choferes WHERE dni = ?"; 
//	private static final String  getCamiones = "SELECT Camiones.dominio, Camiones.marca, Camiones.estado, Camiones.Consumo, Camiones.Litros_por_Tanque, Camiones.Categoria"
//												+ "FROM Camiones INNER JOIN Choferes ON Camiones.Categoria = Choferes.Categoria WHERE Choferes.Categoria = '" + chofer.getId_categoria() +"' AND Camiones.estado = 0"; 

	private static final String insertViaje = "INSERT INTO Viajes"
												+"(dni_chofer,dominio,origen,destino,estado_viaje,tiempo_viaje,cant_tanques)"
												+"VALUES (?,?,?,?,?,?,?)"; 
	@Override	
	public List<Camion> altaViaje(int dni) {
		
		Conexion objCon = new Conexion();
		
		//Camion camion = new Camion(); 
		List<Camion> listaCamiones = new ArrayList<Camion>(); 
		
	try {
		
		/*
		PreparedStatement ps = objCon.conectar().prepareStatement(getChofer);
		ps.setInt(1, chofer.getDni());
		
		/*
		PreparedStatement ps2 = objCon.conectar().prepareStatement(getCamiones);
		ps2.setString(1,chofer.getId_categoria());
		*/
		
		String cat = ""; 
		Statement stm2 = null;
		stm2 = objCon.conectar().createStatement();
		
		ResultSet r=stm2.executeQuery("SELECT * FROM Choferes WHERE DNI= '"+dni+"'");

        while(r.next()){
        cat=r.getString("Categoria");
        }
        
       chofer.setDni(dni);
		
        
		Statement stm = null;
		stm = objCon.conectar().createStatement();
		
		ResultSet rs = stm.executeQuery("SELECT Camiones.dominio, Camiones.marca, Camiones.estado, Camiones.Consumo, Camiones.Litros_por_Tanque, Camiones.Categoria FROM Camiones"
										+ " INNER JOIN Choferes ON Camiones.Categoria = Choferes.Categoria WHERE Choferes.Categoria = '" + cat +"' AND Camiones.estado = 0");
		
		while(rs.next()){
			Camion camion = new Camion();
			
			camion.setDomino(rs.getString("dominio"));
			camion.setMarca(rs.getString("marca"));
			camion.setEstado(rs.getInt("estado"));
			camion.setConsumo(rs.getInt("Consumo"));
			camion.setLitros_tanque(rs.getInt("Litros_por_Tanque"));
			camion.setCategoria(rs.getString("Categoria")); 
			
			listaCamiones.add(camion);
			
		}
		
		
	} catch (Exception e) {
		e.printStackTrace();
		System.out.println("SO SAD");
	}
	
	return listaCamiones;
		
	}
	
	
	@Override
	public void updateViaje(Viaje viaje) {
		
		Conexion objCon = new Conexion();
		CallableStatement clb = null; 
			
		try {
			
			clb = objCon.conectar().prepareCall("{call sp_update_viaje(?,?)}");
			
			clb.setInt(1, viaje.getEstado());
			clb.setInt(2, viaje.getViajeID());
			
			boolean bool = clb.execute(); 
			
			if (bool == false ) {
				System.out.println("Viaje actualizado");
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("No se actulizo el viaje");
		}
		
		
		
	}
	

	@Override
	public List<Viaje> listarViajes(int dni) {
		
		List<Viaje> viajes = new ArrayList<Viaje>();
		Conexion objCon = new Conexion();
		Statement stm = null; 
		
		try {
			
			stm = objCon.conectar().createStatement();
			
			ResultSet r=stm.executeQuery("SELECT * FROM Viajes");   //COOREGIR PARA QUE INGRESE TODOS LOS DNI
			
			while(r.next()){
				Viaje vj = new Viaje(); 
				
				vj.setViajeID(r.getInt("id_viaje"));
				vj.setId_chofer(r.getInt("dni_chofer")); //CAMBIAR DE INT A STRING O AL REVES
				vj.setId_camion(r.getString("dominio"));
				vj.setOrigen(r.getString("origen"));
				vj.setDestino(r.getString("destino"));
				vj.setEstado(r.getInt("estado_viaje"));
				vj.setTiempo_viajes(r.getInt("tiempo_viaje"));
				vj.setCant_tanques(r.getInt("cant_tanques"));
				//FALTAN TIEMPO DE VIAJE Y CANTIDAD DE TANQUES AL OBJTEO VIAJE
				
				viajes.add(vj);
				
			}
			
			stm.close();
			
			return viajes; 
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("No se pudieron mostrar los viajes");	
		}
		
		
		
		return null;
	}	

	@Override
	public void altaRealViaje(String dominio, String origen, String destino) {
		
		Conexion objCon = new Conexion();
		int kms = 0; 
		int lt = 0; 
		int cons = 0; 
		int km_xdia = 200; 
		Statement stm = null;
		ResultSet rs = null; 
		
		try {
			stm = objCon.conectar().createStatement();
			rs = stm.executeQuery("SELECT kms FROM Costos WHERE origen = '"+origen+"' AND destino = '"+destino+"'");
			
			while(rs.next()){
				kms = rs.getInt("kms");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("No se pudo obtener origen y destino");
		}
		
		try {
			
			stm = objCon.conectar().createStatement();
			rs = stm.executeQuery("SELECT Litros_por_Tanque, Consumo FROM Camiones WHERE dominio = '"+dominio+"'");
			
			while(rs.next()){
				lt = rs.getInt("Litros_por_Tanque");
				cons = rs.getInt("Consumo"); 
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("No se pudo obtener los gastos del camion");
		}
		
		
		Viaje viaje = new Viaje(); 
		try {
			
			PreparedStatement ps = objCon.conectar().prepareStatement(insertViaje);
			
			int tv = (kms / km_xdia ); 
			int cntank = ((kms * cons)/lt) ; 
			
			
			ps.setInt(1,chofer.getDni());
			ps.setString(2, dominio);
			ps.setString(3, origen);
			ps.setString(4, destino);
			ps.setInt(5, 0);
			ps.setInt(6, tv);
			ps.setInt(7, cntank);
			
			ps.executeUpdate(); 
			
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("No se pudo insertar el viaje");
		}
		
	
	}

}
