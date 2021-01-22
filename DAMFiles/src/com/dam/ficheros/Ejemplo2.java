package com.dam.ficheros;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Ejemplo2 {

	public static void main(String[] args) throws IOException {
		
		//Leer fichero de texto, carácter a carácter
		FileReader fr = new FileReader(new File("C:\\Users\\diego\\Desktop\\2º DAM\\AAD\\pruebas\\alumnos.txt"));
		
		
		int i = 0;
		while((i = fr.read()) != -1) {
			System.out.println("El número: "+i + " es el carácter:"+ (char)i);
		}
		fr.close();
	
		//Escribir fichero de texto, carácter a carácter
		FileWriter fw = new FileWriter("C:\\Users\\diego\\Desktop\\2º DAM\\AAD\\pruebas\\escrituraDAM.txt", true);
		
		String textoEscribir = "Quiero escribir este texto en el fichero";
		char[] caracteres = textoEscribir.toCharArray();
		
		for (i = 0; i < caracteres.length;i++) 
			fw.write(caracteres[i]);
		
		fw.write("\r");
		
		fw.flush();
		
		fw.close();
		}
	}


