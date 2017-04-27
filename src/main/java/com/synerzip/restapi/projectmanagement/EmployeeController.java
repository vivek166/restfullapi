package com.synerzip.restapi.projectmanagement;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import com.synerzip.employee.model.Employee;
import com.synerzip.employee.servece.EmployeeServicesImpl;

@Path("/employee")
public class EmployeeController {

	EmployeeServicesImpl service = new EmployeeServicesImpl();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{empId}")
	public Employee getEmployee(@PathParam("empId") int empId) {
		return service.getEmployee(empId);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Employee> getEmployees(@DefaultValue("1") @QueryParam("start") int start,
			@DefaultValue("5") @QueryParam("size") int size) {
		System.out.println(start + "" + size);
		return service.getEmployees(start, size);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Employee addEmployee(Employee employee) {
		return service.addEmployee(employee);
	}

	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{empId}")
	public String deleteEmployee(@PathParam("projectId") int empId) {
		return service.deleteEmployee(empId);
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{empId}")
	public Employee updateEmployee(Employee employee, @PathParam("empId") int empId) {
		return service.updateEmployee(employee, empId);
	}
}
