package services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Test {
	public static void main(String[] args) {
		Test test = new Test();
		test.testConnection();
	}

	public void testConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");

		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dept_emp_proj", "root",
					"12345");
			Statement stmt = connection.createStatement();
			String strSelect = "select * from department";
			ResultSet rs = stmt.executeQuery(strSelect);
			while (rs.next()) {
				int id = rs.getInt("dept_id");
				String dName = rs.getString("dept_name");
				String dEmail = rs.getString("dept_email");
				System.out.println(id);
				System.out.println(dName);
				System.out.println(dEmail);
			}
			System.out.println("success connected");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
