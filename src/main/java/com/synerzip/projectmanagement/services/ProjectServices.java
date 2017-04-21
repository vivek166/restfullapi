package com.synerzip.projectmanagement.services;

import com.synerzip.projectmanagement.model.Project;

public interface ProjectServices {

	public abstract String getProject(long projectId);
	
	public abstract String getAllProject();
	
	public abstract String  addProject(Project project);
	
	public abstract String deleteProject(long projectId);
}
