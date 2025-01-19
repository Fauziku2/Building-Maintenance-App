package com.dvops.maven.eclipse;

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

/**
 * Servlet implementation class ReportServlet
 */
@WebServlet("/ReportServlet")
public class ReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReportServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String title = request.getParameter("title");
		String location = request.getParameter("location");
		String description = request.getParameter("description");
		String comment = request.getParameter("comment");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/IssueDetails", "root", "password");
			PreparedStatement ps = con.prepareStatement("insert into ISSUEDETAILS values(?,?,?,?,?,?,?,?,?,?)");
			
			ps.setString(1, title);
			ps.setString(2, description);
			ps.setString(3, location);
			ps.setString(4, name);
			ps.setString(5, email);
			ps.setString(6, phone);
			ps.setString(7, "");
			ps.setString(8, "Unassigned");
			ps.setString(9, "Not Started");
			ps.setString(10, comment);
			
			int i = ps.executeUpdate();
			
			if (i > 0) {
				PrintWriter writer = response.getWriter();
				writer.println("<h1>" + "You have successfully reported an issue!" + "</h1>");
				writer.close();
			}
		}
		catch (Exception exception) {
			System.out.println(exception);
			out.close();
		}
		doGet(request, response);
	}

}
