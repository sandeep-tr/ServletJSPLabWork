package servletpro.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/login" })
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private static final String BAD_LOGIN = "<html><body>Bad Login. <a href=\"login.html\">back</a></body></html>";

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String userName = req.getParameter("username");
		String password = req.getParameter("password");
		if ("master".equalsIgnoreCase(userName) && "master".equals(password)) {
			String userId = String.valueOf(userName.hashCode() + password.hashCode());
			Cookie userCookie = new Cookie("user-id", userId);
			resp.addCookie(userCookie);
			
			resp.getWriter().write("Welcome Xxx");
		} else {
			resp.getWriter().write(BAD_LOGIN);
		}
	}

}
