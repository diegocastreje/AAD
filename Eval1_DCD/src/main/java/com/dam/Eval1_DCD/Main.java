package com.dam.Eval1_DCD;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.dam.pojo.Autores;
import com.dam.pojo.Libros;

public class Main {
	


	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, ClassNotFoundException, SQLException {
				
		ArrayList<Autores> autores = Lectura.leerAutores();
		ArrayList<Libros> libros = Lectura.leerLibros();
		Path ruta = Paths.get("D:\\PRUEBAS\\DCD.csv");
		
		Hibernate hibernate = new Hibernate();
		hibernate.insert(autores);
		
		JDBC jdbc = new JDBC();
		jdbc.insert(libros);
		
		Fichero fichero = new Fichero();
		fichero.crearCSV(autores, libros, ruta);
	}

}
