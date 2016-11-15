package ab.v6.view.servlet.login;

import static util.WebUtil.*;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ab.v6.view.servlet.BaseServlet;

@SuppressWarnings("serial")
public class Logout extends BaseServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		removeSessionAttr(req, "user");

		resp.sendRedirect("/");

	}

}
