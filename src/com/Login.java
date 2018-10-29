package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con;
	PreparedStatement pst;
	ResultSet rs;    
	Statement st;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String connectionUrl = "jdbc:mysql://localhost:3306/assignment3";
		 String connectionUser = "root";
		 String connectionPassword = "root";
		 HttpSession sess = request.getSession();
		 ArrayList<Order> orderList = new ArrayList<Order>();
		 
		 try {
		 Class.forName("com.mysql.jdbc.Driver").newInstance();
		 con = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
		 String query = "SELECT * FROM Customer";
		 st = con.createStatement();
		 rs = st.executeQuery(query);
		 System.out.print("wut");
		 while(rs.next()) {
			 String user =rs.getString("username");
			 String pass =rs.getString("password");
			 
			 if(request.getParameter("uname").equals(user) && request.getParameter("pword").equals(pass)){
				 
				 
				 Customer cus = new Customer();
				 cus.setFirstname(rs.getString("firstname"));
				 cus.setLastname(rs.getString("lastname"));
				 cus.setAddress(rs.getString("address"));
				 cus.setCity(rs.getString("city"));
				 cus.setPostalcode(rs.getString("postalcode"));
				 cus.setUsername(rs.getString("username"));
				 cus.setPassword(rs.getString("password"));
				 cus.setCustomerid(Integer.parseInt(rs.getString("customerid")));
				 sess.setAttribute("cus", cus);
				 query = "Select * from orders where customerid='" +rs.getInt("customerid")+"'";
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
				
				 getServletContext().getRequestDispatcher("/home.jsp").forward(request, response);
			 }
		 
			 
		 }
		response.sendRedirect("/Assignment3/error.jsp");
		 }
		 catch(SQLException e) {
			e.printStackTrace(); 
		 }
		 catch(Exception e){
			e.printStackTrace(); 
		 }
	}

}
