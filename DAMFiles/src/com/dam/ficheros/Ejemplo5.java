package com.dam.ficheros;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;


public class Ejemplo5 {

	public static void main(String[] args) throws IOException {

		Path origen = Paths.get("C:\\Users\\diego\\Desktop\\2º DAM\\AAD\\pruebas\\alumnos.txt");
		Path destino = Paths.get("C:\\Users\\diego\\Desktop\\2º DAM\\AAD\\pruebas\\alumnosCopia.txt");
		
		BufferedReader br = Files.newBufferedReader(origen);
		BufferedWriter bw = Files.newBufferedWriter(destino);

		
		Stream<String> lineas = br.lines();
		
		
		//lineas.forEach(System.out::println);
		lineas.forEach(l ->{
			try {
			bw.write(l + "\n");
			}catch (IOException e) {
				e.printStackTrace();
			}
		});
		
		bw.flush();
		
		br.close();
		bw.close();
		
	}

}
