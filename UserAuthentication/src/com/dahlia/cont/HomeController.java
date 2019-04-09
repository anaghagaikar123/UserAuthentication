package com.dahlia.cont;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/HomeController")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DatabaseConnection connection=new DatabaseConnection();
	Connection db=connection.getConnection();

	public HomeController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session=request.getSession(true);
		PrintWriter writer=response.getWriter();
		response.setContentType("text/html");
		String url1=request.getParameter("login");
		try
		{
		
		if(url1.equals("login"))
		{
			String name=request.getParameter("tuser");
			String pwd=request.getParameter("tpwd");
			System.out.println("login"+name+pwd);
			String query="select * from student where name=?";
			PreparedStatement ps=db.prepareStatement(query);
			ps.setString(1,name);
			ResultSet rs=ps.executeQuery();
			
			if(rs.next())
			{
				request.setAttribute("id",rs.getInt(1));
				request.setAttribute("name",rs.getString(2));
				request.setAttribute("role",rs.getString(3));
				request.setAttribute("password",rs.getString(4));
				request.getRequestDispatcher("PersonalInfo.jsp").forward(request, response);
			}
		}
		}
		catch(Exception e)
		{
			System.out.println("exception occured"+e);
		}
		
		finally
		{
			request.getRequestDispatcher("Error.jsp").forward(request, response);
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
