package com.dam.ficheros;

import java.io.File;
import java.io.IOException;

public class Ejemplo1 {

	public static void main(String[] args) throws IOException {
		
		//Objeto referencia a "C:\\Users\\diego\\Desktop\\2º DAM\\AAD\\pruebas"
		File dirPruebas = new File("C:\\Users\\diego\\Desktop\\2º DAM\\AAD\\pruebas");
	
		//Objeto referencia a "C:\\Users\\diego\\Desktop\\2º DAM\\AAD\\pruebas\\DAM2020, pero sin crearlo"
		File nuevoDir = new File(dirPruebas, "DAM2020");		
		
		//Creacion del directorio
		nuevoDir.mkdir();
		
		//Objeto referencia al nuevo fichero dentro de DAM2020
		File nuevoFichero = new File(nuevoDir, "AD.txt");
		
		//Creamos nuevo fichero
		nuevoFichero.createNewFile();
		
		//Listar el contenido de un directorio
		File[] lista = dirPruebas.listFiles();
		
		for(int i = 0; i < lista.length; i++) 
			System.out.println(lista[i].getName());
		
		

	}

}
