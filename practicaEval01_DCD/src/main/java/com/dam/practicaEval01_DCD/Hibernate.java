package com.dam.practicaEval01_DCD;

import java.io.IOException;
import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.dam.pojo.Departamentos;
import com.dam.pojo.Empleados;

public class Hibernate {

	public Hibernate() {
		
	}
	
	public void init() throws IOException {
		
		StandardServiceRegistry sr = new StandardServiceRegistryBuilder().configure().build();
		SessionFactory sf = new MetadataSources(sr).buildMetadata().buildSessionFactory();
		
		Session session = sf.openSession();
		
		ArrayList<Departamentos> departamentos = LecturaFichero.leerDepartamentos("D:\\PRUEBAS\\departamentos.csv");
		ArrayList<Empleados> empleados = LecturaFichero.leerEmpleados("D:\\PRUEBAS\\empleados.csv");
		
		session.getTransaction().begin();
		
		for(int i = 0; i < departamentos.size(); i++) 
			session.save(departamentos.get(i));
		
		for(int i = 0; i < empleados.size(); i++) 
			session.save(empleados.get(i));
				
		session.getTransaction().commit();
		
		session.close();
		sf.close();
	}
}
