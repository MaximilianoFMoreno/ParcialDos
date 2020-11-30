package edu.usal.negocio.dao.implementacion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import edu.usal.negocio.dao.interfaces.I_ChoferDAO;
import edu.usal.negocio.dominio.Chofer;
import edu.usal.util.Conexion;

public class ChoferDAO_ImpSQL implements I_ChoferDAO{
	
	private static final String insertChofer = "INSERT INTO Choferes"
												+ "(Nombre, Apellido, DNI, Nacimiento, Telefono, user_chofer, pass_chofer, Categoria)"
												+ "VALUES (?,?,?,?,?,?,?,?)";
	
	private static final String insertUsuario = "INSERT INTO Users"
													+ "(usuario,password,dni,tipo_usuario)"
													+ "VALUES (?,?,?,?)";
	
	private static final String updateChofer = "UPDATE Choferes SET Telefono = ? WHERE DNI = ?;"; 
	
	

	//Conexion objCon = new Conexion();
	//Connection con = new Connection(); 
	
	
	@Override
	public void altaChofer(Chofer chofer) throws SQLException {
		
		Conexion objCon = new Conexion();
		
		try{
			
			PreparedStatement ps = objCon.conectar().prepareStatement(insertChofer); 
			ps.setString(1, chofer.getNombre());
			ps.setString(2, chofer.getApellido());
			ps.setInt(3, chofer.getDni());
			ps.setString(4, chofer.getFehca_nacimiento());
			ps.setString(5, chofer.getNro_telefono());
			ps.setString(6, chofer.getUsuario_chofer());
			ps.setString(7, chofer.getContraseña_chofer());
			ps.setString(8, chofer.getId_categoria());
			
			PreparedStatement ps2 = objCon.conectar().prepareStatement(insertUsuario); 
			ps2.setString(1, chofer.getUsuario_chofer());
			ps2.setString(2, chofer.getContraseña_chofer());
			ps2.setInt(3, chofer.getDni());
			ps2.setString(4, "Chofer");
			
			ps.executeUpdate(); 
			ps2.executeUpdate();
			
			
			/*
			Statement stm = objCon.conectar().createStatement(); 
			int rows = stm.executeUpdate(insertChofer);
			if(rows > 0) {
				System.out.println("Chofer Registrado"); 
			}else{
				System.out.println("Error al insertar");
			}
			
			*/
			/*
		//objCon.conectar(); 
		PreparedStatement ps = objCon.conectar().prepareStatement(insertChofer);
		ps.setString(1, "a");
		ps.setString(2, "b");
		ps.setInt(3, 10);
		ps.setString(4, "tel");
		ps.setString(5, "user");
		ps.setString(6, "pass");
		
		ps.executeUpdate(); 
		*/
		}catch (Exception e) {
			System.out.println("No se pudo insertar");
			e.printStackTrace();
		}
		
	}

	@Override
	public void bajaChofer(int DNI) throws SQLException {
		
		Conexion objCon = new Conexion();
		Statement stm = null; 
		
		try {
			
			stm = objCon.conectar().createStatement(); 
		
			stm.execute("DELETE FROM Choferes\n" + "WHERE DNI ='" + DNI + "'"); 
			
			System.out.println("Chofer eliminado");
			
			
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
	public void updateChofer(Chofer chofer) {
		
		Conexion objCon = new Conexion();
		
		try {
			
			PreparedStatement ps = objCon.conectar().prepareStatement(updateChofer);
			
			ps.setString(1, chofer.getNro_telefono() );
			ps.setInt(2, chofer.getDni());
			
			ps.executeUpdate();
			
			
		} catch (Exception e) {
			
			System.out.println("No se pudo actualizar");
			e.printStackTrace();
		}
		
		
	}

}
