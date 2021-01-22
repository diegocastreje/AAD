package com.dam.Eval1_DCD;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.dam.pojo.Autores;

public class Hibernate {
	
	public Hibernate() {
		
	}

	public void insert(ArrayList<Autores> autores) {
		
		StandardServiceRegistry sr = new StandardServiceRegistryBuilder().configure().build();
		SessionFactory sf = new MetadataSources(sr).buildMetadata().buildSessionFactory();
		
		Session session = sf.openSession();
		
		session.getTransaction().begin();

		for(int i = 0; i < autores.size(); i++) 
			session.save(autores.get(i));
	
		session.getTransaction().commit();
		
		session.close();
		sf.close();
		
	}

}
