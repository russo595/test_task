package util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class WebUtil {

	public static <T> T removeSessionAttr(HttpServletRequest req, String key) {
		HttpSession session = req.getSession(false);
		return removeAttr(session, key);
	}

	public static <T> T getSessionAttr(HttpServletRequest req, String key) {
		HttpSession session = req.getSession(false);
		return getAttr(session, key);
	}

	@SuppressWarnings("unchecked")
	public static <T> T getAttr(HttpSession session, String key) {

		if (session == null)
			return null;

		return (T) session.getAttribute(key);
	}

	@SuppressWarnings("unchecked")
	public static <T> T removeAttr(HttpSession session, String key) {

		if (session == null)
			return null;

		Object out = session.getAttribute(key);

		session.removeAttribute(key);

		return (T) out;
	}

	public static String cleanHtml(String val) {

		if (val == null)
			return null;

		val = val.replace('"', ' ');
		val = val.replace('<', ' ');
		val = val.replace('>', ' ');
		val = val.replace('/', ' ');
		val = val.trim();

		return val;
	}

}
