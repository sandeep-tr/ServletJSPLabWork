package com.bootcamp.servletpro.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bootcamp.servletpro.data.UserData;
import com.bootcamp.servletpro.utilities.HibernateUtilities;

@WebServlet(urlPatterns = { "/login" })
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private static final String BAD_LOGIN = "<html><body>Bad Login. <a href=\"login\">back</a></body></html>";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("Entering login get method.");
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/pages/login.html");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("Entering login post method.");
		
		String userName = req.getParameter("username");
		String password = req.getParameter("password");

		// -- calls data layer and validates user
		UserData userData = new UserData();
		int userId = userData.validateUser(userName, password);

		if (userId > -1) {
			req.getSession().setAttribute("userName", userName);
			
			Cookie userCookie = new Cookie("user-id", String.valueOf(userId));
			resp.addCookie(userCookie);
			resp.sendRedirect(getServletContext().getContextPath() + "/home");
		} else {
			resp.getWriter().write(BAD_LOGIN);
		}
	}

	@Override
	public void destroy() {
		HibernateUtilities.getSessionFactory().close();
	}

}
