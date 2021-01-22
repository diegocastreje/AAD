package com.dam.DAMHibernate_CamposDerivados;

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

		session.getTransaction().begin();
		
		Usuario usuario1 = new Usuario("Diego", "root");
		Usuario usuario2 = new Usuario("Jose", "guapo");
		
		session.save(usuario1);		
		session.save(usuario2);

		session.getTransaction().commit();
		
		session.close();
		sf.close();

	}

}
