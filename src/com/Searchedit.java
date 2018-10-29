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
 * Servlet implementation class Searchedit
 */
@WebServlet("/Searchedit")
public class Searchedit extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con;
	PreparedStatement pst;
	ResultSet rs;    
	Statement st; 
	String query;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Searchedit() {
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
			 Class.forName("com.mysql.jdbc.Driver").newInstance();
			 con = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
			 Customer cus = (Customer) sess.getAttribute("cus");
			 Integer in = cus.getCustomerid();
			 pst = con.prepareStatement("UPDATE orders set itemname = ? ,price = ?,quantity = ? where orderid = ?");
			 pst.setString(1, request.getParameter("iname"));
			 pst.setDouble(2, Double.parseDouble(request.getParameter("price")));
			 pst.setInt(3, Integer.parseInt(request.getParameter("quantity")));
			 pst.setInt(4,Integer.parseInt(request.getParameter("id")));
			 pst.executeUpdate();
			
			 
			 
			 getServletContext().getRequestDispatcher("/home.jsp").forward(request, response);
			 
			 ArrayList<Order> orderList = new ArrayList<Order>();
			 query = "Select * from orders where customerid='" +in+"'";
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
			 		orderList.add(ord);
			 }
			 sess.setAttribute("ord", orderList);
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
