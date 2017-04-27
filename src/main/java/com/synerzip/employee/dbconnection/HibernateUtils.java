package com.synerzip.employee.dbconnection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.synerzip.employee.model.Employee;

public class HibernateUtils {

	static Configuration con;
	static SessionFactory sessionFactory;
	static {
		con = new Configuration().configure().addAnnotatedClass(Employee.class);
		sessionFactory = con.buildSessionFactory();
	}

	public static Session getSession() {
		return sessionFactory.openSession();
	}
}
