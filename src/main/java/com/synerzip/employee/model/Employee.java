package com.synerzip.employee.model;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.synerzip.projectmanagement.model.Project;

@Entity
@Table(name = "employee")
public class Employee {

	@Id
	@Column(name = "emp_id")
	int empId;
	@Column(name = "emp_name")
	String empName;
	@Column(name = "emp_department")
	String empDepartment;
	@Column(name = "emp_subject")
	String empSubjects;

	@ManyToMany(targetEntity = Project.class)
	@JoinTable(name = "employee_project")
	private Set<Project> project;

	public Set<Project> getProject() {
		return project;
	}

	public void setProject(Set<Project> project) {
		this.project = project;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpDepartment() {
		return empDepartment;
	}

	public void setEmpDepartment(String empDepartment) {
		this.empDepartment = empDepartment;
	}

	public String getEmpSubjects() {
		return empSubjects;
	}

	public void setEmpSubjects(String empSubjects) {
		this.empSubjects = empSubjects;
	}

	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empDepartment=" + empDepartment
				+ ", empSubjects=" + empSubjects + "]";
	}
}
