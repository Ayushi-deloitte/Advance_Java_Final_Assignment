package com.ayushi.registration;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stubregister
		
		String uname=request.getParameter("name");
		String uemail=request.getParameter("email");
		String upassword=request.getParameter("pass");
		String umobile=request.getParameter("contact");
		RequestDispatcher dispatcher=null;
		Connection con=null;
		
			try {
                Class.forName("com.mysql.cj.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost/pole?useSSL=false","root","Ayushi@123");
				System.out.println(con);
				 PreparedStatement ps=con.prepareStatement("insert into users(uname,upassword,uemail,umobile) values(?,?,?,?)");
				ps.setString(1,uname);
				ps.setString(2,upassword);
				ps.setString(3, uemail);
				ps.setString(4, umobile);
				
				int rc=ps.executeUpdate();
				dispatcher=request.getRequestDispatcher("registration.jsp");
				
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
//			finally
//			{
//				try {
//					con.close();
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
			
		

	}

}
