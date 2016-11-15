package ab.v6.view.servlet;

import static util.WebUtil.*;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ab.v6.model.AddressRec;

/**
 * Список текущих записей и возможность добавить новую
 */
@SuppressWarnings("serial")
public class ListView extends BaseServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession(false);
		List<AddressRec> recs = app.getAllRecs();

		req.setAttribute("recs", recs);
		req.setAttribute("error", removeAttr(session, "error"));
		req.setAttribute("oldOwner", removeAttr(session, "oldOwner"));
		req.setAttribute("oldAddr", removeAttr(session, "oldAddr"));

		req.getRequestDispatcher("/WEB-INF/jsp/list.jsp").forward(req, resp);

	}

}
