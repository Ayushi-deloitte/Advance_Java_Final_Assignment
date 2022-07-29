package com.ayushi.registration;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/complaint")
public class ComplaintServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		int pole_id=Integer.parseInt(request.getParameter("pole_id"));
		String Address=request.getParameter("Address");
		String City=request.getParameter("City");
		int Pin_code=Integer.parseInt(request.getParameter("Pin_code"));
		int Mobile=Integer.parseInt(request.getParameter("Mobile"));
		
		RequestDispatcher dispatcher=null;
		Connection con=null;
		
			try {
                Class.forName("com.mysql.cj.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost/pole?useSSL=false","root","Ayushi@123");
				System.out.println(con);
				 PreparedStatement ps=con.prepareStatement("insert into complain(pole_id,Address,City,Pin_code,Mobile_Number) values(?,?,?,?,?)");
				 
				 ps.setInt(1, pole_id);
				 ps.setString(2,Address);
				 ps.setString(3, City);
				 ps.setInt(4, Pin_code);
				 ps.setInt(5, Mobile);
				 System.out.println(ps);
				 
				
				int rc=ps.executeUpdate();
				dispatcher=request.getRequestDispatcher("adminPage.jsp");
				
				if(rc>0)
				{
					
					request.setAttribute("status", "success");
					
				}
				else
				{
					request.setAttribute("status", "failed");

				}
				dispatcher.forward(request, response);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		
		
	}

}
