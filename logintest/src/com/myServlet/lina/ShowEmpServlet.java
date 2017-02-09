package com.myServlet.lina;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.elements.lina.Department;
import com.elements.lina.Employee;

import services.DepartmentService;
import services.EmployeeService;

/**
 * Servlet implementation class ShowEmpServlet
 */
@WebServlet("/ShowEmpServlet")
public class ShowEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShowEmpServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// get all depts ready for dropdownlist
		ArrayList<Department> deptList = DepartmentService.getDeptList();
		request.setAttribute("departments", deptList);

		// get all employee ready for display
		ArrayList<Employee> empList = EmployeeService.getEmpList();
		request.setAttribute("employees", empList);

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
