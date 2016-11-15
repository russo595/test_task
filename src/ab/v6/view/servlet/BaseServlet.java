package ab.v6.view.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import ab.v6.App;

@SuppressWarnings("serial")
public class BaseServlet extends HttpServlet {

	protected App app;

	@Override
	public void init() throws ServletException {

		ServletContext sc = getServletContext();
		app = (App) sc.getAttribute("app");

	}

}
