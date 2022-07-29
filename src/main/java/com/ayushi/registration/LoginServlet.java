package com.ayushi.registration;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */



@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uemail=request.getParameter("username");
		String upassword=request.getParameter("password");
		HttpSession session=request.getSession();
		RequestDispatcher dispatcher=null;
		Connection con=null;

		
		if("admin@gmail.com".equals(uemail) && "admin".equals(upassword))
		{
			session.setAttribute("uemail", uemail);
			dispatcher=request.getRequestDispatcher("adminPage.jsp");
		}
		else
		{
		
			try {
                Class.forName("com.mysql.cj.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost/pole?useSSL=false","root","Ayushi@123");
				System.out.println(con);
				 PreparedStatement ps=con.prepareStatement("select * from users where uemail=? and upassword=?");
				 
				ps.setString(1, uemail);

				ps.setString(2,upassword);
				
				ResultSet rs=ps.executeQuery();
				
				if(rs.next())
				{
					session.setAttribute("name",rs.getString("uname"));
					dispatcher=request.getRequestDispatcher("index.jsp");
					
				}
				else
				{
					dispatcher=request.getRequestDispatcher("login.jsp");
				}
				
				dispatcher.forward(request, response);

				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		
		
	}

}
