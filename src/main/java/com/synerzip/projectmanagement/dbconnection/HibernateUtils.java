package com.synerzip.projectmanagement.dbconnection;

import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.synerzip.projectmanagement.model.Project;

public class HibernateUtils {
	public static Session getSession() {
		Configuration con = new Configuration().configure().addAnnotatedClass(
				Project.class);
		ServiceRegistry registry = new ServiceRegistryBuilder().applySettings(
				con.getProperties()).buildServiceRegistry();

		SessionFactory sf = con.buildSessionFactory(registry);
		return sf.openSession();
	}
}