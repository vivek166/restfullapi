package com.synerzip.projectmanagement.services;

import java.util.List;

import javax.ws.rs.core.Response;

import com.synerzip.projectmanagement.model.Project;
import com.synerzip.projectmanagement.responce.RecordNotFoundException;
public interface ProjectServices {

	Response getProject(long projectId) throws RecordNotFoundException;

	List<Project> getAllProject();

	Project addProject(Project project);

	String deleteProject(long projectId);

	Project updateProject(Project project, long projectId);

	List<Project> getProjects(int start, int size);
}
