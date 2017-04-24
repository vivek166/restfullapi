package com.synerzip.restapi.projectmanagement;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

import com.synerzip.projectmanagement.model.Project;
import com.synerzip.projectmanagement.services.ProjectServiceImplementation;

@Path("/project")
public class ProjectController {

	ProjectServiceImplementation service = new ProjectServiceImplementation();

	/*@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getAllProject() {
		return service.getAllProject();
	}*/

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{projectId}")
	public String getProject(@PathParam("projectId") long projectId) {
		return service.getProject(projectId);
	}

	@GET
	public String getProjectPaginated(@QueryParam("start") int start,
			@QueryParam("size") int size) {
		System.out.println(start + "" + size);
		return service.getAllProjectPaginated(start, size);
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

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{projectId}")
	public String updateProject(Project project,
			@PathParam("projectId") long projectId) {
		return service.updateProject(project, projectId);
	}
}
