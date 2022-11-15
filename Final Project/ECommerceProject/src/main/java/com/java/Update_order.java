package com.java;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Update_order")
public class Update_order extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		String pn=request.getParameter("p_name");
		String pq=request.getParameter("p_qty");
		String pe=request.getParameter("p_email");
		String pa=request.getParameter("p_address");
		
		Product_bean b2=new Product_bean();
		b2.setP_name(pn);
		b2.setP_qty(pq);
		b2.setP_email(pe);
		b2.setP_address(pa);
		
		try
		{
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/core","root","");
			PreparedStatement ps=con.prepareStatement("update bookorder set p_qty=?, p_email=?, p_address=? where p_name=?");
			
			ps.setString(1, pq);
			ps.setString(2, pe);
			ps.setString(3, pa);
			ps.setString(4, pn);
			int j=ps.executeUpdate();
			
			
			if(j>0)
			{
				pw.print("Updated successfully");
				pw.print("<br><br><a href='Show_order.jsp'>Click her to view changes</a>");
				//response.sendRedirect("Show_order.jsp");
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
