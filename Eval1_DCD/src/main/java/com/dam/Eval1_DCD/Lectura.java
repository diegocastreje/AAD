package com.dam.Eval1_DCD;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.dam.pojo.Autores;
import com.dam.pojo.Libros;

public class Lectura {
	
	private static String rutaXML = "D:\\PRUEBAS\\biblioteca.xml";
	private static ArrayList<Libros> libros = new ArrayList<Libros>();
	private static ArrayList<Autores> autores = new ArrayList<Autores>();
	
	public Lectura() {
		
	}
	
	private static Document crearDoc() throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();				
		FileInputStream fis = new FileInputStream(new File(rutaXML));
		Document leer = db.parse(fis);
		return leer;
		
	}
	
	public static ArrayList<Autores> leerAutores() throws ParserConfigurationException, SAXException, IOException{		
		
		Document leer = crearDoc();
		
		NodeList codigo = leer.getElementsByTagName("Codigo");
		NodeList nombre = leer.getElementsByTagName("Nombre");
		NodeList pais = leer.getElementsByTagName("Pais");
		
		for(int i = 0; i < codigo.getLength(); i++) 
			autores.add(new Autores(Integer.parseInt(codigo.item(i).getTextContent()),nombre.item(i).getTextContent(),pais.item(i).getTextContent()));
			
		return autores;
	}
	
	public static ArrayList<Libros> leerLibros() throws ParserConfigurationException, SAXException, IOException {
		
		Document leer = crearDoc();
		
		NodeList isbn = leer.getElementsByTagName("ISBN");
		NodeList titulo = leer.getElementsByTagName("Titulo");
		NodeList editorial = leer.getElementsByTagName("Editorial");
		NodeList codAutor = leer.getElementsByTagName("CodAutor");
		
		for(int i = 0; i < isbn.getLength(); i++) 
			libros.add(new Libros(isbn.item(i).getTextContent(),titulo.item(i).getTextContent(),editorial.item(i).getTextContent(),Integer.parseInt(codAutor.item(i).getTextContent())));
		
		return libros;
		
	}

}
