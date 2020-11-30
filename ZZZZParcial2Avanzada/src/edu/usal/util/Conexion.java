package edu.usal.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Conexion {
	
public Connection conectar(){
		
		Connection con = null;
		
		try {
			
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); 
			con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=Parcial2","Maxi","123456");
			
			if (con.isValid(0)) {
				System.out.println("Conexion Establecida");	
				
				/*
				String insertChofer = "INSERT INTO Choferes"
						+ "(Nombre, Apellido, DNI, Nacimiento, Telefono, user_chofer, pass_chofer )"
						+ "VALUES ('a','b','1','c','d','e','f')"; 
				
				Statement stm = con.createStatement();
				int rows = stm.executeUpdate(insertChofer); 
				
				if(rows > 0) {
					System.out.println("Chofer Registrado"); 
				}else{
					System.out.println("Error al insertar");
				}
				*/
				
			}
			
		} catch (Exception e) {
			System.out.println("No se pudo conectar");
			e.printStackTrace();
		}
		
		return con;
		
		
	}
	
}
