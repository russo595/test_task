package ab.v6.model;

public class User {

	public String login;
	public String pswHash;
	public String name;

	public User(String login, String pswHash, String name) {
		this.login = login;
		this.pswHash = pswHash;
		this.name = name;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		return result;
	}

	public String getLogin() {
		return login;
	}

	public String getName() {
		return name;
	}

}
