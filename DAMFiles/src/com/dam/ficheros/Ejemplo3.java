package com.dam.ficheros;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Ejemplo3 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\diego\\Desktop\\2º DAM\\AAD\\pruebas\\alumnos.txt"));
		
		String linea;
		while ((linea = br.readLine()) !=null)
			System.out.println(linea);
		
		br.close();
		
		//Escritura con Buffer
		
		BufferedWriter bw = new BufferedWriter(new FileWriter ("C:\\Users\\diego\\Desktop\\2º DAM\\AAD\\pruebas\\escrituraDAM.txt", true));
		
		
		String nuevaLinea = "\rLínea nueva en el fichero";
		
		bw.write(nuevaLinea);
		bw.flush();

	}

}
