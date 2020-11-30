package edu.usal.negocio.dao.implementacion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import edu.usal.negocio.dao.interfaces.I_CamionDAO;
import edu.usal.negocio.dominio.Camion;
import edu.usal.util.Conexion;

public class CamionDAO_ImpSQL implements I_CamionDAO{
	
	private static final String insertCamion = "INSERT INTO Camiones (dominio, marca, Toneladas_Maximas, Litros_por_Tanque, estado, Consumo, Categoria)" 
			+ "VALUES (?,?,?,?,?,?,?)"; 
	
	
	//Error en el dao, el anteultimo ";" esta de mas Y ME ROMPE LA QUERY, 
	//Con la modificacion la query anda bien, debo actualizar el dao de el web project 
	//private static final String updateCamion = "UPDATE Camiones SET Toneladas_Maximas  = ?, "
	//+ "Litros_por_Tanque = ?, Consumo = ?, Categoria = ? WHERE dominio = ?";
	
	private static final String updateCamion = "UPDATE Camiones SET Toneladas_Maximas  = ?, "
			+ "Litros_por_Tanque = ?, Consumo = ?, Categoria = ? WHERE dominio = ?";
	
	
	Conexion objCon = new Conexion(); 
	//Connection con = null;
	
	
	@Override
	public void altaCamion(Camion camion) throws SQLException {
		
		Conexion objCon = new Conexion();
		
		
		try {
			 
			PreparedStatement ps = objCon.conectar().prepareStatement(insertCamion);
			
			ps.setString(1, camion.getDomino());
			ps.setString(2, camion.getMarca());
			ps.setInt(3, camion.getToneladas_max());
			ps.setInt(4, camion.getLitros_tanque());
			ps.setInt(5, camion.getEstado());
			ps.setInt(6, camion.getConsumo());
			ps.setString(7, camion.getCategoria());
			
			ps.executeUpdate(); 
			
			
			/*
			pps.setString(1, camion.getDomino());
			pps.setString(2, camion.getMarca());
			pps.setInt(3, camion.getToneladas_max());
			pps.setInt(4, camion.getLitros_tanque());
			pps.setInt(5, camion.getEstado());
			//pps.setString(6, camion.getCategoria());
			pps.setInt(6, camion.getConsumo());
		*/
			
			ps.close();
			//con.close();
			
			
		} catch (Exception e) {
			
			System.out.println("No se inserto el camion");
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void bajaCamion(String dominio) {
		
		Conexion objCon = new Conexion();
		Statement stm = null; 
		
		try {
			
			stm = objCon.conectar().createStatement(); 
			stm.execute("DELETE FROM Camiones\n" + "WHERE dominio ='" + dominio + "'");
			
			System.out.println("Camion eliminado");
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println("No se pudo eliminar");
		}
		
		try {
            stm.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
	
		
	}

	@Override
	public void updateCamion(Camion camion) {
	
		Conexion objCon = new Conexion();
		
		try {
			PreparedStatement ps = objCon.conectar().prepareStatement(updateCamion);
			
			ps.setInt(1,camion.getToneladas_max()); 
			ps.setInt(2, camion.getLitros_tanque());
			ps.setInt(3, camion.getConsumo());
			ps.setString(4, camion.getCategoria());
			ps.setString(5, camion.getDomino());
			
			
		} catch (Exception e) {
			
			System.out.println("No se pudo actualizar");
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	

}
