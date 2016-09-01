package com.bootcamp.servletpro.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = { "/logout" })
public class LogoutServlet extends HttpServlet {

	private static final long serialVersionUID = 2952386149012066182L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("Entering logout get method.");

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/pages/logout.html");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("Entering logout post method.");

		unsetCookies(req, resp);
		// -- invalidating session
		HttpSession session = req.getSession(false);
		if (session != null) {
			System.out.println("Invalidating session.");
			session.invalidate();
		}
		resp.sendRedirect(getServletContext().getContextPath() + "/login");
	}

	private void unsetCookies(HttpServletRequest req, HttpServletResponse resp) {
		Cookie[] cookies = req.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {

				cookie.setValue(null);
				cookie.setMaxAge(0);
				resp.addCookie(cookie);
			}
		}
	}
}
