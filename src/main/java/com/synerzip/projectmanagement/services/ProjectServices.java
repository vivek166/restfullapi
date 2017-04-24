package com.synerzip.projectmanagement.services;

import java.util.List;

import com.synerzip.projectmanagement.model.Project;

public interface ProjectServices {

	Project getProject(long projectId);

	List<Project> getAllProject();

	Project addProject(Project project);

	String deleteProject(long projectId);

	Project updateProject(Project project, long projectId);

	List<Project> getProjects(int start, int size);
}
