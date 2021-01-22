package com.dam.damhibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Principal {

	public static void main(String[] args) {
		
		StandardServiceRegistry sr = new StandardServiceRegistryBuilder().configure().build();
		SessionFactory sf = new MetadataSources(sr).buildMetadata().buildSessionFactory();
		
		Session session = sf.openSession();
		
		Alumno alumno1 = new Alumno(100, "Alumno1", 23);
		Alumno alumno2 = new Alumno(200, "Alumno2", 37);
		
		session.getTransaction().begin();
		session.save(alumno1);
		session.save(alumno2);
		session.getTransaction().commit();
		
		session.close();
		sf.close();

	}

}
