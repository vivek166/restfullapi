package com.synerzip.restapi.projectmanagement;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;

import com.synerzip.projectmanagement.model.Project;
import com.synerzip.projectmanagement.services.ProjectService;

@Path("/project")
public class ProjectSystem {

	ProjectService service = new ProjectService();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Project> getAllProject() {
		return service.getAllProject();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{projectId}")
	public Project getProject(@PathParam("projectId") long projectId) {
		return service.getProject(projectId);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String addProject(Project project) {
		return service.addProject(project);
	}

	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{projectId}")
	public String deleteProject(@PathParam("projectId") long projectId) {
		return service.deleteProject(projectId);
	}
}
