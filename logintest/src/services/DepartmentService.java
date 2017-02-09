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

public class DepartmentService {

	static final EntityManagerFactory EMF = Persistence.createEntityManagerFactory("logintest");

	public static void addDept(String dName, String dEmail) {
		EntityManager em = EMF.createEntityManager();
		em.getTransaction().begin();
		Department dept = new Department();
		dept.setName(dName);
		dept.setEmail(dEmail);
		em.persist(dept);
		em.getTransaction().commit();
		em.close();
	}

	public static ArrayList<Department> getDeptList() {
		EntityManager em = EMF.createEntityManager();
		em.getTransaction().begin();
		Query query = em.createQuery("select d from Department d");
		List<Department> deptlist = query.getResultList();
		em.getTransaction().commit();
		em.close();
		return (ArrayList<Department>) deptlist;
	}

}
