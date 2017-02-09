package services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.elements.lina.*;

public class EmployeeService {

	static final EntityManagerFactory EMF = Persistence.createEntityManagerFactory("logintest");

	public static void addEmp(String firstName, String lastName, int age, int deptId) {
		EntityManager em = EMF.createEntityManager();
		em.getTransaction().begin();
		// create a new employee
		Employee emp = new Employee();
		emp.setFirstName(firstName);
		emp.setLastName(lastName);
		emp.setAge(age);

		// set department to the employee
		Department dept = em.find(Department.class, deptId);
		emp.setDepartment(dept);

		em.persist(emp);
		em.flush();
		em.getTransaction().commit();
		em.close();
	}

	public static ArrayList<Employee> getEmpList() {
		EntityManager em = EMF.createEntityManager();
		em.getTransaction().begin();
		Query query = em.createQuery("select e from Employee e");
		List<Employee> empList = query.getResultList();
		em.getTransaction().commit();
		em.close();
		return (ArrayList<Employee>) empList;
	}

}
