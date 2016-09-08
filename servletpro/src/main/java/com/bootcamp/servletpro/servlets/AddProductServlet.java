package com.bootcamp.servletpro.servlets;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bootcamp.servletpro.data.ProductData;
import com.bootcamp.servletpro.objects.Product;
import com.bootcamp.servletpro.utilities.ServletUtilities;

@WebServlet(urlPatterns = { "/addproduct" })
public class AddProductServlet extends HttpServlet {

	private static final long serialVersionUID = 3377387347253428264L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("Entering addproduct get method.");

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/pages/addproduct.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Entering addproduct post method.");
		try {
			Product product = retreiveParamsAndCreateProduct(req);
			ProductData productData = new ProductData();
			productData.saveProduct(product);
		} catch (IllegalArgumentException iae) {
			sendBadArgumentResponse(resp);
			return;
		}
		redirectToHome(resp);
	}

	private Product retreiveParamsAndCreateProduct(HttpServletRequest req) throws IllegalArgumentException {

		String name = req.getParameter("name");
		String description = req.getParameter("description");
		String quantity = req.getParameter("quantity");
		String price = req.getParameter("price");

		Product product = new Product();
		try {
			product.setName(name);
			product.setDescription(description);
			product.setQuantity(Integer.parseInt(quantity));
			product.setPrice(Long.parseLong(price));
			product.setDate(new Date());
			String userId = ServletUtilities.findCookie(req, "user-id");
			product.setUserId(Integer.parseInt(userId));
			return product;
		} catch (NumberFormatException | NullPointerException ne) {
			System.out.println("Exception in retreiveParamsAndCreateProduct - " + ne);
			throw new IllegalArgumentException(ne.getMessage());
		}
	}

	private void redirectToHome(HttpServletResponse resp) throws IOException {
		resp.sendRedirect(getServletContext().getContextPath() + "/home");
	}

	private void sendBadArgumentResponse(HttpServletResponse resp) throws IOException {
		resp.getWriter().write("Invalid arguments passed.");
	}

}
