package com.dam.ficheros;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ejemplo4 {

	public static void main(String[] args) throws IOException {
		
		int tamanho = 32*1024;
		byte[] buffer = new byte[tamanho];
		int cantidadLeida = 0;
		
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream("C:\\Users\\diego\\Desktop\\2º DAM\\AAD\\pruebas\\pdf pruebas bis.pdf"));
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("C:\\Users\\diego\\Desktop\\2º DAM\\AAD\\pruebas\\copia pdf.pdf"));
		
		while ((cantidadLeida = bis.read(buffer, 0, tamanho)) != -1)
			bos.write(buffer, 0, cantidadLeida);
			
			bos.flush();
			
			bis.close();
			bos.close();
	}

}
