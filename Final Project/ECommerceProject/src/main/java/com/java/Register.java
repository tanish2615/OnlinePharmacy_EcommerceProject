package com.java;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		String n=request.getParameter("name");
		String p=request.getParameter("pass");
		String e=request.getParameter("email");
		String a=request.getParameter("address");
		String mn=request.getParameter("mobno");
		
		Bean b1=new Bean();
		b1.setName(n);
		b1.setPassword(p);
		b1.setEmail(e);
		b1.setAddress(a);
		b1.setMobno(mn);
		

		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/core","root","");
			PreparedStatement ps=con.prepareCall("insert into entry values (?,?,?,?,?)");
			ps.setString(1, n);
			ps.setString(2, p);
			ps.setString(3, e);
			ps.setString(4, a);
			ps.setString(5, mn);
			int k=ps.executeUpdate();
			if(k>0)
			{
				pw.print("Successfully Registered");
				pw.print("<br><br><a href='login1.html'>Click here to go to Login Page</a>");
			}
			else
			{
				System.out.println("Error");
			}
		}
		catch(Exception e2)
		{
			System.out.println(e2);
		}

	}

}
