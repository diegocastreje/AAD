package com.dam.damjdbc;

/*
 * elegir entre mysql postgresql o salir
 * driver, ruta, usuario y contraseña para mysql y lo mismo para postgresql en un fichero property
 */



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SelectJDBC {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		int opcion = scan();
		while(opcion != 3) {	
		System.out.println("Elige entre usar: \n 1. MySQL \n 2. PostgreSQL |n 3. Salir");
		
		switch(opcion) {
		
		case 1: 
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexionSQL = DriverManager.getConnection("jdbc:mysql://localhost/sakila?serverTimezone=Europe/Madrid", "root", "");
			Statement consultaSQL = conexionSQL.createStatement();
			ResultSet resultadosSQL = consultaSQL.executeQuery("SELECT * FROM actor");

			while(resultadosSQL.next())
				System.out.println(resultadosSQL.getInt(1) + ", " + resultadosSQL.getString(2) + ", " + resultadosSQL.getString(3) + ", " + resultadosSQL.getTimestamp(4));
			
			resultadosSQL.close();
			consultaSQL.close();
			conexionSQL.close();
			
		case 2:
			Class.forName("org.postgresql.Driver");
			Connection conexionPOSTGRE = DriverManager.getConnection("jdbc:postgresql://localhost/sakila", "postgres", "root");
			Statement consultaPOSTGRE = conexionPOSTGRE.createStatement();
			ResultSet resultadosPOSTGRE = consultaPOSTGRE.executeQuery("SELECT * FROM actor");
			
			while(resultadosPOSTGRE.next())
				System.out.println(resultadosPOSTGRE.getInt(1) + ", " + resultadosPOSTGRE.getString(2) + ", " + resultadosPOSTGRE.getString(3) + ", " + resultadosPOSTGRE.getTimestamp(4));
			
			resultadosPOSTGRE.close();
			consultaPOSTGRE.close();
			conexionPOSTGRE.close();
			
		case 3:
			
			System.exit(0);
			
		}}
		
		//1. Registrar el driver
		
		//Registrar el driver PostgreSQL
		
		//2. Obtenemos la conexion
		
		//Obtenemos una conexion para PostgreSQL
		//3. Creamos el statement
		
		
		
		//4. Ejecutamos el statement
		
		//5. Mostramos los resultados
		
		
		//6. Cerramos los objetos
		
	}
	private static int scan() {
		Scanner s = new Scanner(System.in);
		int respuesta = s.nextInt();
		return respuesta;
	}
	
}
