package com.bootcamp.servletpro.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/home" })
public class HomeServlet extends HttpServlet {

	private static final long serialVersionUID = -6624522962807885654L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("Entering home get method.");

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/pages/home.jsp");
		dispatcher.forward(req, resp);
	}

}
