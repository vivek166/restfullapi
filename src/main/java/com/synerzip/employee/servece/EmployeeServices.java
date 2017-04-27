package com.synerzip.employee.servece;

import java.util.List;

import com.synerzip.employee.model.Employee;

public interface EmployeeServices {

	Employee getEmployee(int empId);

	List<Employee> getAllEmployee();

	List<Employee> getEmployees(int start, int size);

	Employee addEmployee(Employee empId);

	String deleteEmployee(int empId);

	Employee updateEmployee(Employee employee, int empId);
}
