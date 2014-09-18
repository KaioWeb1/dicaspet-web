package com.dicaspet.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.dicaspet.entidade.Animal;
import com.dicaspet.entidade.Mensagem;
import com.dicaspet.entidade.Servico;
import com.dicaspet.entidade.Usuario;

public class HibernateUtil {

	private static SessionFactory sessionFactory;

	static {
		Configuration configuration = new Configuration();
		
		configuration.addAnnotatedClass(Usuario.class);
		configuration.addAnnotatedClass(Animal.class);
		configuration.addAnnotatedClass(Servico.class);
		configuration.addAnnotatedClass(Mensagem.class);
	

		
		configuration.configure();
		ServiceRegistryBuilder serviceRegistryBuilder = new ServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		ServiceRegistry serviceRegistry = serviceRegistryBuilder
				.buildServiceRegistry();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	}

	public static Session getSession() {
		Session session = sessionFactory.openSession();
		return session;
	}

}