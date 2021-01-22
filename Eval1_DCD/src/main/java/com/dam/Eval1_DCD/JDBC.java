package com.dam.Eval1_DCD;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.dam.pojo.Libros;

public class JDBC {
	
	public JDBC(){
		
	}
	
	public void insert(ArrayList<Libros> libros) throws ParserConfigurationException, SAXException, IOException, ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conexionSQL = DriverManager.getConnection("jdbc:mysql://localhost/Eval1?serverTimezone=Europe/Madrid", "root", "root");
		
		PreparedStatement prepSQL = conexionSQL.prepareStatement("INSERT INTO libros VALUES(?,?,?,?)");

		for(int i = 0; i < libros.size(); i++) {
			prepSQL.setString(1, libros.get(i).getIsbn());
			prepSQL.setInt(2, libros.get(i).getCodAutor());
			prepSQL.setString(3, libros.get(i).getEditorial());
			prepSQL.setString(4, libros.get(i).getTitulo());			
			
			prepSQL.executeUpdate();
			
		}
		
		prepSQL.close();
		conexionSQL.close();	
		
	}

}
