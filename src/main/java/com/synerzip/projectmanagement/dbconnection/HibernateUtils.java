package com.synerzip.projectmanagement.dbconnection;

import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.synerzip.projectmanagement.model.Project;

public class HibernateUtils {

	static Configuration con;
	static ServiceRegistry registry;
	static SessionFactory sf;
	static {
		System.out.println("started initialising hibernate config");
		con = new Configuration().configure().addAnnotatedClass(Project.class);
		registry = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
		sf = con.buildSessionFactory(registry);
		System.out.println("completed with hibernate config init");
	}

	public static Session getSession() {
		return sf.openSession();

	}
}