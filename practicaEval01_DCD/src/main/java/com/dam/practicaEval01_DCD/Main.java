package com.dam.practicaEval01_DCD;

import java.io.IOException;
import java.sql.SQLException;

public class Main {	
	
	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException{
		
		Hibernate hibernate = new Hibernate();
		hibernate.init();
		
		JDBC jdbc = new JDBC();
		jdbc.init();
	}
}