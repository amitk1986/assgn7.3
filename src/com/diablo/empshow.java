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
 * Servlet implementation class empshow
 */
@WebServlet("/empshow")
public class empshow extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("hi");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/Employee";
			String usr = "root";
			String pwd = "root";
			Connection con = DriverManager.getConnection(url, usr, pwd);
			System.out.println("Connection established..");
			Statement stm = con.createStatement();
			/* select statement*/
			ResultSet rs = stm.executeQuery("select * from emp");
			response.setContentType("text/html");
			PrintWriter pp = response.getWriter();
			pp.println("<!DOCTYPE html>");
			pp.println("<HTML>");
		    pp.println("<TITLE>convertor</TITLE>");
		    pp.println("<BODY>");
		    pp.println("<table style='width:50%'>");
		    pp.println("<tr>");
		    pp.println("<th>");
		    pp.println("id");
		    pp.println("</th>");
		    pp.println("</tr>");
		    pp.println("<tr>");
		    pp.println("<th>");
		    pp.println("name");
		    pp.println("</th>");
		    pp.println("</tr>");
		    
		    while (rs.next())
			{
		    	pp.println("<tr>");
			    
			    pp.println("<td>"+rs.getString(1)+"</td>");
			   
			    pp.println("</tr>");
			    pp.println("<tr>");
			   
			    pp.println("<td>"+rs.getString(2)+"</td>");
			    
			    pp.println("</tr>");
	}
		    pp.println("</table>");
		    pp.println("</BODY>");
		    pp.println("</HTML>");

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
