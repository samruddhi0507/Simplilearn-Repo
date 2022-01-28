package com.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.file.Matcher;

import com.entity.product;


/**
 * Servlet implementation class ProductController
 */
@WebServlet("/ProductController")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductController() {
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
		Map<String, String> errors = new HashMap<String, String>();
		String productDescription = "";
		HttpSession session = request.getSession();
		Pattern pattern = Pattern.compile(regex);
		java.util.regex.Matcher matcher = pattern.matcher(request.getParameter("productCategory"));
		
		if(!matcher.matches()) {
			errors.put("invalidCateg","Invalid category<br/>");
		}
		if(request.getParameter("productName").length() == 0) {
			errors.put("nullProdName","Enter a product name<br/>");
		}
		if(request.getParameter("productDescription").length() == 0) {
			productDescription = "No description";
		}else {
			productDescription = request.getParameter("productDescription");
		}
		try {
			Integer.parseInt(request.getParameter("productId"));
		}catch(NumberFormatException e) {
			errors.put("notInt", "<br/>Invalid product ID<br/>");
		}
		if(errors.isEmpty()) {
			product p1 = new product(Integer.parseInt(request.getParameter("productId")), request.getParameter("productName"), request.getParameter("productCategory"), productDescription);
			session.setAttribute("product", p1);
			response.sendRedirect("display.jsp");
		}else {
			session.setAttribute("errors", errors);
			response.sendRedirect("index.jsp");
		}
		
	}
	}


