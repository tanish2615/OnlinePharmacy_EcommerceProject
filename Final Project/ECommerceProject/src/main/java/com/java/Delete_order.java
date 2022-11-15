package com.java;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Delete_order")
public class Delete_order extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		String pn=request.getParameter("p_name");
		
		Product_bean b3=new Product_bean();
		b3.setP_name(pn);
		
		try
		{
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/core","root","");
			PreparedStatement ps=con.prepareStatement("delete from bookorder where p_name=?");
		
			ps.setString(1, pn);
			int j=ps.executeUpdate();
			
			if(j>0)
			{
				response.sendRedirect("Show_order.jsp");
			}
			else
			{
				pw.print("Error !");
			}
		}
		catch(Exception e1)
		{
			System.out.println(e1);
		}

		
	}

}
