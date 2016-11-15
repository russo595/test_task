package ab.v6;

import static ab.v6.model.Const.*;
import static util.CryptoUtil.*;
import static util.Util.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;

import ab.v6.model.AddressBook;
import ab.v6.model.AddressRec;
import ab.v6.model.User;
import ab.v6.model.Users;
import ab.v6.store.Storage;

public class App {

	Logger log = getLog(getClass());

	Storage<AddressBook> booksStorage;
	Storage<Users> usersStorage;

	AddressBook books;
	Users users;

	public void init(Storage<AddressBook> booksStorage, Storage<Users> usersStorage) throws IOException {

		this.booksStorage = booksStorage;
		this.usersStorage = usersStorage;

		try {
			books = booksStorage.load(AddressBook.class);
		} catch (FileNotFoundException e) {
			books = new AddressBook();
		}

		try {
			users = usersStorage.load(Users.class);
		} catch (FileNotFoundException e) {
			users = new Users();
		}

	}

	public synchronized List<AddressRec> getAllRecs() {
		return books.getAll();
	}

	public synchronized void addRec(String owner, String addr) throws IOException {

		books.add(owner, addr);

		booksStorage.save(books);

		log.info("added rec");

	}

	public synchronized User addUser(String login, String psw, String name) throws Exception {

		String pswHash = sha256Hash(PSW_SALT, psw);

		User user = new User(login, pswHash, name);

		boolean added = users.addUser(user);

		if (!added)
			return null;

		usersStorage.save(users);

		log.info("added user: " + user.login);

		return user;

	}

	public synchronized User getUser(String login, String psw) throws Exception {

		String pswHash = sha256Hash(PSW_SALT, psw);

		return users.getUser(login, pswHash);
	}

}
