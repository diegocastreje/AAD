package com.dam.Eval1_DCD;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

import com.dam.pojo.Autores;
import com.dam.pojo.Libros;

public class Fichero {
	
	public Fichero() {
		
	}
	
	public void crearCSV(ArrayList<Autores> autores, ArrayList<Libros> libros, Path ruta) throws IOException {
		
		BufferedWriter bw = Files.newBufferedWriter(ruta);		
		
		for(int i = 0; i < autores.size(); i++) 
			bw.write(autores.get(i).getCodigo() + ", " + autores.get(i).getNombre() + ", " + autores.get(i).getPais() + "\n ");
		
		for(int i = 0; i < libros.size(); i++) 
			bw.write(libros.get(i).getIsbn() + ", " + libros.get(i).getTitulo() + ", " + libros.get(i).getEditorial() + ", " + libros.get(i).getCodAutor() + "\n ");
		
		bw.flush();
		bw.close();
		
	}

}
