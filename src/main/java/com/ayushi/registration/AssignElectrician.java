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

/**
 * Servlet implementation class AssignElectrician
 */
@WebServlet("/assignElectrician")
public class AssignElectrician extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id=Integer.parseInt(request.getParameter("id"));
		String name=request.getParameter("name");
		String mobile_number=request.getParameter("mobile_number");
		
		RequestDispatcher dispatcher=null;
		Connection con=null;
		
			try {
                Class.forName("com.mysql.cj.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost/pole?useSSL=false","root","Ayushi@123");
				System.out.println(con);
				 PreparedStatement ps=con.prepareStatement("insert into electrician(id,name,mobile_number) values(?,?,?)");
				 
				 ps.setInt(1, id);
				 ps.setString(2,name);
				 ps.setString(3, mobile_number);
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
