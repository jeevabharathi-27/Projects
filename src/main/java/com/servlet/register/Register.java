package com.servlet.register;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/RegisterServlet")
public class Register extends HttpServlet {
	
	  String INSERT_QUERY ="INSERT INTO DETAILS(NAME,EMAIL,MOBILE,GENDER,CITY)VALUES(?,?,?,?,?)";
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter pw=response.getWriter();
		response.setContentType("text/html");
		
		String Name=request.getParameter("name");
		String Email=request.getParameter("email");
		String Mobile=request.getParameter("mobile");
		String Gender=request.getParameter("gender");
		String City=request.getParameter("city");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/webinar","root","1234");
			
			String checkQuery="SELECT MOBILE FROM DETAILS WHERE MOBILE=?";
			
			PreparedStatement checkStatement=con.prepareStatement(checkQuery);
			checkStatement.setString(1,Mobile);
			ResultSet resultSet=checkStatement.executeQuery();
			
			if(resultSet.next())
			{
				RequestDispatcher rd=request.getRequestDispatcher("welcome1.jsp");
				rd.forward(request,response);
			}
			else
			{
				PreparedStatement ps=con.prepareStatement(INSERT_QUERY);
				
				ps.setString(1, Name);
				ps.setString(2, Email);
				ps.setString(3, Mobile);
				ps.setString(4, Gender);
				ps.setString(5, City);
				
				int count=ps.executeUpdate();
				if(count !=0)
				{
					RequestDispatcher rd=request.getRequestDispatcher("welcome.jsp");
					rd.forward(request,response);
				}	
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		 
	}
}
