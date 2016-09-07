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
import com.bootcamp.servletpro.utilities.ServletUtilities;

@WebServlet(urlPatterns = { "/products" })
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

		String temp = ServletUtilities.findCookie(req, "user-id");
		int userId = -1;
		if (temp != null) {
			userId = Integer.parseInt(temp);
			List<Product> products = fetchProductsBasedOnUser(userId, req);
			req.setAttribute("data", products);
			dispatchRequestToProductPage(req, resp);
		} else {
			redirectToLoginPage(resp);
		}
	}

	private List<Product> fetchProductsBasedOnUser(int userId, HttpServletRequest req) {

		String userType = (String) req.getSession().getAttribute("userType");
		ProductData productData = new ProductData();
		if ("admin".equals(userType)) {
			return productData.fetchAllProducts();
		} else {
			return productData.fetchUserProducts(userId);
		}
	}

	private void dispatchRequestToProductPage(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/pages/products.jsp");
		dispatcher.forward(req, resp);
	}

	private void redirectToLoginPage(HttpServletResponse resp) throws IOException {
		resp.sendRedirect(getServletContext().getContextPath() + "/login");
	}
}
