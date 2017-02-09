package com.myServlet.lina;

import com.elements.lina.*;

import services.DepartmentService;
import services.EmployeeService;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AddEmpServlet
 */
@WebServlet("/AddEmpServlet")
public class AddEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddEmpServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");
		int age = Integer.parseInt(request.getParameter("age"));
		int deptId = Integer.parseInt(request.getParameter("deptSelect"));

		EmployeeService.addEmp(firstName, lastName, age, deptId);

		ArrayList<Employee> empList = EmployeeService.getEmpList();
		request.setAttribute("employees", empList);

		// get all depts ready for dropdownlist
		ArrayList<Department> deptList = DepartmentService.getDeptList();
		request.setAttribute("departments", deptList);

		request.getRequestDispatcher("addEmp.jsp").include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
