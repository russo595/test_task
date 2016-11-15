package ab.v6.model;

import java.util.HashMap;
import java.util.Map;

public class Users {

	private Map<String, User> users = new HashMap<>();

	public boolean addUser(User user) {

		String login = user.login;

		if (users.containsKey(login))
			return false;

		users.put(login, user);
		return true;
	}

	public User getUser(String login, String pswHash) {

		User user = users.get(login);

		if (user == null || !user.pswHash.equals(pswHash))
			return null;

		return user;

	}

}
