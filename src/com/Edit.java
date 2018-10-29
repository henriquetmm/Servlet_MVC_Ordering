package com;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Edit
 */
@WebServlet("/Edit")
public class Edit extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con;
	PreparedStatement pst;
	ResultSet rs;    
	Statement st;   
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Edit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String connectionUrl = "jdbc:mysql://localhost:3306/assignment3";
		String connectionUser = "root";
		String connectionPassword = "root";
		HttpSession sess = request.getSession();
		 
		 try {
			 Customer cus = (Customer) sess.getAttribute("cus");
			 Class.forName("com.mysql.jdbc.Driver").newInstance();
			 con = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
			 pst = con.prepareStatement("UPDATE customer SET username = ?,password = ?,firstname = ?"
			 		+ ",lastname = ?,address = ?,city = ?,postalcode = ? WHERE username ='" +  cus.getUsername()+"'");
			 pst.setString(1, request.getParameter("uname"));
			 pst.setString(2, request.getParameter("pword"));
			 pst.setString(3, request.getParameter("fname"));
			 pst.setString(4, request.getParameter("lname"));
			 pst.setString(5, request.getParameter("add"));
			 pst.setString(6, request.getParameter("city"));
			 pst.setString(7, request.getParameter("pcode"));
			 
			 
			 pst.executeUpdate();
			 
			 cus.setFirstname(request.getParameter("fname"));
			 cus.setLastname(request.getParameter("lname"));
			 cus.setAddress(request.getParameter("add"));
			 cus.setCity(request.getParameter("city"));
			 cus.setPostalcode(request.getParameter("pcode"));
			 cus.setUsername(request.getParameter("uname"));
			 cus.setPassword(request.getParameter("pword"));
			 
			 sess.setAttribute("cus", cus);
			 getServletContext().getRequestDispatcher("/home.jsp").forward(request, response);
			 
		 }
		 catch(SQLException e) {
			 e.printStackTrace();
		 }
		 catch(Exception e){
			 e.printStackTrace(); 
		 }
		 
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
