package com.synerzip.projectmanagement.services;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.synerzip.projectmanagement.dbconnection.HibernateUtils;
import com.synerzip.projectmanagement.model.Project;

public class ProjectServiceImplementation implements ProjectServices {

	public Project getProject(long projectId) {

		Session session = HibernateUtils.getSession();
		org.hibernate.Transaction tx = session.beginTransaction();

		try {
			Project project = (Project) session.get(Project.class, projectId);
			tx.commit();
			return project;
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
			Query query = session.createQuery("from com.synerzip.projectmanagement.model.Project");
			query.setMaxResults(5);
			List<Project> projects = query.list();
			return projects;
		} catch (Exception e) {
			return null;
		} finally {
			session.close();
		}
	}

	public Project addProject(Project project) {

		Session session = HibernateUtils.getSession();
		org.hibernate.Transaction tx = session.beginTransaction();

		try {
			session.save(project);
			tx.commit();
			return project;
		} catch (Exception e) {
			return null;
		} finally {
			session.close();
		}
	}

	public String deleteProject(long projectId) {

		Session session = HibernateUtils.getSession();
		org.hibernate.Transaction tx = session.beginTransaction();

		try {
			String deleteQuery = "DELETE FROM Project WHERE project_id = " + projectId + "";
			Query query = session.createQuery(deleteQuery);
			query.executeUpdate();
			tx.commit();
		} catch (Exception e) {
			return null;
		} finally {
			session.close();
		}
		return "record deleted";
	}

	public Project updateProject(Project project, long projectId) {
		Session session = HibernateUtils.getSession();
		org.hibernate.Transaction tx = session.beginTransaction();

		try {
			String deleteQuery = "DELETE FROM Project WHERE project_id = " + projectId + "";
			Query query = session.createQuery(deleteQuery);
			query.executeUpdate();
			session.save(project);
			tx.commit();
			return project;
		} catch (Exception e) {
			return null;
		} finally {
			session.close();
		}
	}

	public List<Project> getProjects(int start , int size) {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		try {
			Query query = session.createQuery("from com.synerzip.projectmanagement.model.Project");
			query.setFirstResult(start);
			query.setMaxResults(start + size);
			List<Project> projects = query.list();
			ArrayList<Project> projectList = new ArrayList<>(projects);
			if (start + size > projectList.size())
				return projectList;
			else
				return projectList.subList(start, size + start);
		} catch (Exception e) {
			return null;
		}
	}
}
