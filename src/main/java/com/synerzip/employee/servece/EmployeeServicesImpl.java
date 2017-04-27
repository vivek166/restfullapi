package com.synerzip.employee.servece;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.synerzip.employee.dbconnection.HibernateUtils;
import com.synerzip.employee.model.Employee;

public class EmployeeServicesImpl implements EmployeeServices {

	public Employee getEmployee(int empId) {

		Session session = HibernateUtils.getSession();
		org.hibernate.Transaction tx = session.beginTransaction();

		try {
			Employee employee = (Employee) session.get(Employee.class, empId);
			tx.commit();
			return employee;
		} catch (Exception e) {
			return null;
		} finally {
			session.close();
		}
	}

	public List<Employee> getAllEmployee() {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		try {
			Query query = session.createQuery("from com.synerzip.employee.model.Employee");
			query.setMaxResults(5);
			List<Employee> employees = query.list();
			return employees;
		} catch (Exception e) {
			return null;
		} finally {
			session.close();
		}
	}

	public Employee addEmployee(Employee employee) {

		Session session = HibernateUtils.getSession();
		org.hibernate.Transaction tx = session.beginTransaction();

		try {
			session.save(employee);
			tx.commit();
			return employee;
		} catch (Exception e) {
			return null;
		} finally {
			session.close();
		}
	}

	public String deleteEmployee(int empId) {

		Session session = HibernateUtils.getSession();
		org.hibernate.Transaction tx = session.beginTransaction();

		try {
			String deleteQuery = "DELETE FROM Employee WHERE emp_id = :emp_id";
			Query query = session.createQuery(deleteQuery);
			query.setParameter("emp_id", empId);
			query.executeUpdate();
			tx.commit();
		} catch (Exception e) {
			return null;
		} finally {
			session.close();
		}
		return "record deleted";
	}

	public Employee updateEmployee(Employee employee, int empId) {
		Session session = HibernateUtils.getSession();
		org.hibernate.Transaction tx = session.beginTransaction();

		try {
			String deleteQuery = "DELETE FROM Employee WHERE emp_id = :emp_id";
			Query query = session.createQuery(deleteQuery);
			query.setParameter("emp_id", empId);
			query.executeUpdate();
			session.save(employee);
			tx.commit();
			return employee;
		} catch (Exception e) {
			return null;
		} finally {
			session.close();
		}
	}

	public List<Employee> getEmployees(int start, int size) {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		try {
			Query query = session.createQuery("from com.synerzip.employee.model.Employee");
			query.setFirstResult(start);
			query.setMaxResults(start + size);
			List<Employee> employees = query.list();
			ArrayList<Employee> empList = new ArrayList<>(employees);
			if (start + size > empList.size())
				return empList;
			else
				return empList.subList(start, size + start);
		} catch (Exception e) {
			return null;
		}
	}
}
