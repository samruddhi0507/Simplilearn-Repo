package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class QueryServlet
 */
@WebServlet("/QueryServlet")
public class QueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryServlet() {
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
		// TODO Auto-generated method stub
		boolean found = false;
		boolean invalid = false;
		int ProductID = 0;
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		RequestDispatcher rd = null;
		try {
			 ProductID = Integer.parseInt(request.getParameter("ProductID"));
		}catch(NumberFormatException e){
			rd = request.getRequestDispatcher("index.html");
			rd.include(request, response);
			invalid = true;
			out.print("Invalid product ID" + "<br/>");
		}
		String ProductName = "";
		String sql = "select * from Product where ProductID=?";
	
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); 			
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Product","root","Samruddhi@97R");
			pst = conn.prepareStatement(sql);
			pst.setString(1, request.getParameter("ProductID"));
			ResultSet rs = pst.executeQuery();
			
			rs.last();
			if (rs.getRow() > 0) {
				ProductName = rs.getString(2);
				found = true;
			}
			if(found) {
				rd = request.getRequestDispatcher("index.html");
				rd.include(request, response);
				out.print("Product Found!" + "<br/>");
				out.print("ProductID:" + ProductID + "<br/>" + "Product Name: " + ProductName + "<br/>");
			}else if(invalid == false){
				rd = request.getRequestDispatcher("index.html");
				rd.include(request, response);
				out.print("ProductID:" + ProductID + " is not found" + "<br/>");
			}
			conn.close();
		}catch(ClassNotFoundException e) {
			try {
				conn.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}catch(SQLException e) {
			try {
				conn.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	}

