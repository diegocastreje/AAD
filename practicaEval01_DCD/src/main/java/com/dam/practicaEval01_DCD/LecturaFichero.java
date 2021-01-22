package com.dam.practicaEval01_DCD;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;

import com.dam.pojo.Departamentos;
import com.dam.pojo.Empleados;

public class LecturaFichero {
	
	
	static ArrayList<Empleados> empleados = new ArrayList<Empleados>();
	static ArrayList<Departamentos> departamentos = new ArrayList<Departamentos>();
	
	public static ArrayList leerEmpleados(String ruta) throws IOException {
		Path csv = Paths.get(ruta);
		BufferedReader br = Files.newBufferedReader(csv);
		Stream<String> lineas = br.lines();
		
		lineas.forEach(linea ->{
			
			String[] campos = linea.split(",");		
			empleados.add(new Empleados(Integer.parseInt(campos[0]), campos[1], campos[2], campos[3], Integer.parseInt(campos[4]), Integer.parseInt(campos[5])));
			
		});

		return empleados;
	}
	public static ArrayList leerDepartamentos(String ruta) throws IOException {
		Path csv = Paths.get(ruta);
		BufferedReader br = Files.newBufferedReader(csv);
		Stream<String> lineas = br.lines();
		
		lineas.forEach(linea ->{
			
			String[] campos = linea.split(",");		
			departamentos.add(new Departamentos(Integer.parseInt(campos[0]), campos[1], campos[2]));
			
		});

		return departamentos;
	}

}
