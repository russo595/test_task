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
public class NewUser extends BaseServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String name = cleanHtml(req.getParameter("name"));
		String login = cleanHtml(req.getParameter("login"));
		String psw = cleanHtml(req.getParameter("psw"));

		try {

			if (isEmpty(login) || isEmpty(psw) || isEmpty(name))
				throw new IllegalArgumentException("Не заполнены все данные");

			User added = app.addUser(login, psw, name);

			if (added == null)
				throw new IllegalArgumentException("Такой пользователь уже есть");

			req.getSession().setAttribute("user", added);
			resp.sendRedirect("/");

		} catch (Exception e) {

			OldFormData old = new OldFormData();
			old.error = e.getMessage();
			old.vals.put("login", login);
			old.vals.put("psw", psw);
			old.vals.put("name", name);

			req.getSession().setAttribute("oldNew", old);
			resp.sendRedirect("/login");

		}

	}

}
