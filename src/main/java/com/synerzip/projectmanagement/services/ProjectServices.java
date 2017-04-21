package com.synerzip.projectmanagement.services;

import com.synerzip.projectmanagement.model.Project;

public interface ProjectServices {

	  String getProject(long projectId);
	
	  String getAllProject();
	
	  String  addProject(Project project);
	
	  String deleteProject(long projectId);
	
	  String updateProject(Project project , long projectId);
}
