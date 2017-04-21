package com.synerzip.projectmanagement.services;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.synerzip.projectmanagement.dbconnection.HibernateUtils;
import com.synerzip.projectmanagement.model.Project;

public class ProjectService {

	public Project getProject(long projectId) {

		Session session = HibernateUtils.getSession();
		org.hibernate.Transaction tx = session.beginTransaction();

		try {
			Project s = (Project) session.get(Project.class, projectId);
			tx.commit();
			return s;
		} catch (Exception e) {
			return null;
		} finally {
			session.close();
		}
	}

	public List<Project> getAllProject() {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		try {
			Query query = session
					.createQuery("from com.synerzip.projectmanagement.model.Project");
			List<Project> projects = query.list();
			return projects;
		} catch (Exception e) {
			return null;
		} finally {
			session.close();
		}
	}

	public String addProject(Project project) {

		Session session = HibernateUtils.getSession();

		org.hibernate.Transaction tx = session.beginTransaction();

		try {
			session.save(project);
			tx.commit();
			return "data saved";
		} catch (Exception e) {
			return "something went wrong";
		} finally {
			session.close();
		}

	}

	public String deleteProject(long projectId) {

		Session session = HibernateUtils.getSession();

		org.hibernate.Transaction tx = session.beginTransaction();

		try {
			String hql = "DELETE FROM Project WHERE project_id = " + projectId
					+ "";
			Query query = session.createQuery(hql);
			int status = query.executeUpdate();
			tx.commit();
			System.out.println(status);
		} catch (Exception e) {
			return "something went wrong";
		} finally {
			session.close();
		}
		return "record deleted";
	}
}
