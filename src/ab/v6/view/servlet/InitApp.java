package ab.v6.view.servlet;

import static util.Util.*;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.log4j.Logger;

import ab.v6.App;
import ab.v6.model.AddressBook;
import ab.v6.model.Users;
import ab.v6.store.JSONStorageImpl;
import ab.v6.store.Storage;

@SuppressWarnings("serial")
public class InitApp extends HttpServlet {

	Logger log = getLog(getClass());

	@Override
	public void init() throws ServletException {
		try {

			ServletContext sc = getServletContext();

			String serverPath = System.getenv("CATALINA_HOME");
			if (serverPath == null)
				serverPath = System.getProperty("catalina.home");
			if (serverPath == null)
				throw new IllegalStateException("can't find server home");

			File dir = new File("./address-book-v6-login");
			log.info("data dir: " + dir);

			App app = createApp(dir);

			sc.setAttribute("app", app);

		} catch (Exception e) {
			throw new ServletException("can't init", e);
		}
	}

	public static App createApp(File storeDir) throws IOException {

		File booksFile = new File(storeDir, "v6_books.json");
		File usersFile = new File(storeDir, "v6_users.json");

		Storage<AddressBook> booksStorage = new JSONStorageImpl<>(booksFile);
		Storage<Users> usersStorage = new JSONStorageImpl<>(usersFile);

		App app = new App();
		app.init(booksStorage, usersStorage);

		return app;

	}

}
