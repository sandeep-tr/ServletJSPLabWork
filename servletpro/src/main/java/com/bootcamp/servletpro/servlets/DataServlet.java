package com.bootcamp.servletpro.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bootcamp.servletpro.data.ProductData;
import com.bootcamp.servletpro.objects.Product;

@WebServlet(urlPatterns = { "/data" })
public class DataServlet extends HttpServlet {

	private static final long serialVersionUID = 8872710400553056420L;

	@Override
	public void init() throws ServletException {
		List<String> productHeads = new ArrayList<>();
		productHeads.add("Name");
		productHeads.add("Date");
		productHeads.add("Description");
		productHeads.add("Quantity");
		productHeads.add("Price");
		getServletContext().setAttribute("productHeads", productHeads);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("Entering data get method.");
		
		ProductData productData = new ProductData();
		List<Product> products = productData.fetchProducts();

		// -- attaching product list to requestScope
		req.setAttribute("data", products);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/pages/products.jsp");
		dispatcher.forward(req, resp);
	}

}
