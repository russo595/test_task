package ab.v6.view.servlet.login;

import static util.Util.*;
import static util.WebUtil.*;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ab.v6.model.User;
import ab.v6.view.model.OldFormData;
import ab.v6.view.servlet.BaseServlet;

@SuppressWarnings("serial")
public class EnterUser extends BaseServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String login = cleanHtml(req.getParameter("login"));
		String psw = cleanHtml(req.getParameter("psw"));

		try {

			if (isEmpty(login) || isEmpty(psw))
				throw new IllegalArgumentException("Не заполнены все данные");

			User exists = app.getUser(login, psw);

			if (exists == null)
				throw new IllegalArgumentException("Неверный логин или пароль");

			req.getSession().setAttribute("user", exists);
			resp.sendRedirect("/");

		} catch (Exception e) {

			OldFormData old = new OldFormData();
			old.error = e.getMessage();
			old.vals.put("login", login);
			old.vals.put("psw", psw);

			req.getSession().setAttribute("oldEnter", old);
			resp.sendRedirect("/login");

		}

	}

}
