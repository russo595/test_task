package ab.v6.view.servlet.book;

import static util.Util.*;
import static util.WebUtil.*;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ab.v6.view.servlet.BaseServlet;

@SuppressWarnings("serial")
public class AddRec extends BaseServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String owner = cleanHtml(req.getParameter("owner"));
		String addr = cleanHtml(req.getParameter("address"));

		try {

			if (isEmpty(owner) || isEmpty(addr))
				throw new IllegalArgumentException("Не заполнены все данные");

			app.addRec(owner, addr);

		} catch (Exception e) {

			HttpSession session = req.getSession(true);
			session.setAttribute("oldOwner", owner);
			session.setAttribute("oldAddr", addr);
			session.setAttribute("error", e.getMessage());

		}

		resp.sendRedirect("/");

	}

}
