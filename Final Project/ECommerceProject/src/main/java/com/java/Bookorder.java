
package com.java;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Bookorder")
public class Bookorder extends HttpServlet {
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
			PreparedStatement ps=con.prepareStatement("insert into bookorder (p_name,p_qty, p_email, p_address) values(?,?,?,?)");
			
			ps.setString(1, pn);
			ps.setString(2, pq);
			ps.setString(3, pe);
			ps.setString(4, pa);
			
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
