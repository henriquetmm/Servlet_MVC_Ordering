package com;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Editorder
 */
@WebServlet("/Editorder")
public class Editorder extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con;
	PreparedStatement pst;
	ResultSet rs;    
	Statement st; 
	String query;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Editorder() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String connectionUrl = "jdbc:mysql://localhost:3306/assignment3";
		String connectionUser = "root";
		String connectionPassword = "root";
		HttpSession sess = request.getSession();
		
		 try {
			 Class.forName("com.mysql.jdbc.Driver").newInstance();
			 con = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
		
			 ArrayList<Order> orderSearch = new ArrayList<Order>();
			 query = "Select * from orders where orderid='" +request.getParameter("id")+"'";
			 st = con.createStatement();
			 rs = st.executeQuery(query);
			 	while(rs.next()) {
			 		Order ord = new Order(); 
			 		ord.setOrderid(rs.getInt("orderid"));
			 		ord.setCustomerid(rs.getInt("customerid"));
			 		ord.setDate(rs.getDate("orderdate"));
			 		ord.setPrice(rs.getDouble("price"));
			 		ord.setQuantity(rs.getInt("quantity"));
			 		ord.setItemname(rs.getString("itemname"));
			 		orderSearch.add(ord);
			 }
			 sess.setAttribute("search", orderSearch);
			 
			 getServletContext().getRequestDispatcher("/editsearch.jsp").forward(request, response);
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
