package com.synerzip.projectmanagement.services;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.google.gson.Gson;
import com.synerzip.projectmanagement.dbconnection.HibernateUtils;
import com.synerzip.projectmanagement.model.Project;
import com.synerzip.projectmanagement.responce.ResponseHandler;

public class ProjectServiceImplementation implements ProjectServices {

	ResponseHandler handle=new ResponseHandler();
	Gson gson =new Gson();
	
	public String getProject(long projectId) {

		
		Session session = HibernateUtils.getSession();
		org.hibernate.Transaction tx = session.beginTransaction();

		try {
			Project newProject = (Project) session.get(Project.class, projectId);
			tx.commit();
			return gson.toJson(newProject.toString());
		} catch (Exception e) {
			return handle.getErrorResponce();
		} finally {
			session.close();
		}
	}

	public String getAllProject() {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		try {
			Query query = session.createQuery("from com.synerzip.projectmanagement.model.Project");
			List<Project> projects = query.list();
			return gson.toJson(projects.toString());
		} catch (Exception e) {
			return handle.getAllErrorResponce();
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
			return gson.toJson(project.toString());
		} catch (Exception e) {
			return handle.postErrorResponce();
		} finally {
			session.close();
		}

	}

	public String deleteProject(long projectId) {

		Session session = HibernateUtils.getSession();

		org.hibernate.Transaction tx = session.beginTransaction();

		try {
			String deleteQuery = "DELETE FROM Project WHERE project_id = " + projectId+ "";
			Query query = session.createQuery(deleteQuery);
			query.executeUpdate();
			tx.commit();
		} catch (Exception e) {
			return handle.deleteErrorResponce();
		} finally {
			session.close();
		}
		return gson.toJson("record deleted");
	}
}
