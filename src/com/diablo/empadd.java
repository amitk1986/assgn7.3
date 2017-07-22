package com.diablo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class empadd
 */
@WebServlet("/empadd")
public class empadd extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("hi");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/Employee";
			String usr = "root";
			String pwd = "root";
			Connection con = DriverManager.getConnection(url, usr, pwd);
			System.out.println("Connection established..");
			Statement stm = con.createStatement();
			int i = Integer.parseInt(request.getParameter("id"));
			String sts = request.getParameter("name");
			int j = stm.executeUpdate("insert into emp values ("+i+",'"+sts+"')");
			response.setContentType("text/html");
			PrintWriter pw = response.getWriter();
			pw.println("<!DOCTYPE html>");
			pw.println("<HTML>");
			pw.println("<head><meta http-equiv='refresh' content='3;URL=http://localhost:8080/assgn7.3/empshow'></head>");
			pw.println("<BODY>"); 
			pw.println("record added successfully");
			pw.println("</body>");
			pw.println("</html>");
			 
			  
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
