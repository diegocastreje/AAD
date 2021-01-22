package com.dam.practicaEval01_DCD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC {
	
	public JDBC() {
		
	}
	
	public void init() throws ClassNotFoundException, SQLException {
		
		Class.forName("org.postgresql.Driver");
		Connection conexion = DriverManager.getConnection("jdbc:postgresql://localhost/empresa?serverTimezone=Europe/Madrid", "postgres", "root");
		Statement consulta = conexion.createStatement();
		ResultSet resultado1 = consulta.executeQuery("SELECT nombre FROM empresa.departamentos");
		ResultSet resultado2 = consulta.executeQuery("SELECT * FROM empresa.empleados WHERE idDepartamento=20");
		
		System.out.println("Los nombres de las empresas son:\n ");
		while(resultado1.next())
			System.out.println(resultado1.getString(1));
		
		System.out.println("\nLos datos de los empleados de la empresa con id 20 son:\n ");
		while(resultado2.next())
			System.out.println(resultado2.getInt(1) + ", " + resultado2.getString(2) + 
					", " + resultado2.getInt(3) + ", " + resultado2.getString(4) + 
					", " + resultado2.getInt(5) + ", " + resultado2.getString(6));
		
		resultado2.close();
		resultado1.close();
		consulta.close();
		conexion.close();
	}

}
