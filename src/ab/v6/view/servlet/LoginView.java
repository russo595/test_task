package ab.v6.view.servlet;

import static util.WebUtil.*;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ab.v6.model.User;

/**
 * Страница входа и регистрации
 */
@SuppressWarnings("serial")
public class LoginView extends BaseServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		User curUser = getSessionAttr(req, "user");
		if (curUser != null) {
			resp.sendRedirect("/");
			return;
		}

		req.setAttribute("skipUserBlock", true);

		req.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(req, resp);

		removeSessionAttr(req, "oldEnter");
		removeSessionAttr(req, "oldNew");

	}

}
