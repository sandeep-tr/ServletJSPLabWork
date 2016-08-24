package servletpro;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/hello" })
public class HelloWorldServlet extends HttpServlet {

	private static final long serialVersionUID = 1732660449957728288L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/helloworld.jsp");
		// -- sets request scope variable
		req.setAttribute("message", "Welcome, today is Monday ...");
		dispatcher.forward(req, resp);
	}
}
