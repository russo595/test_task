package ab.v6.model;

import java.util.ArrayList;
import java.util.List;

public class AddressBook {

	private List<AddressRec> recs = new ArrayList<>();

	public void add(String owner, String address) {
		AddressRec rec = new AddressRec(owner, address);
		add(rec);
	}

	public void add(AddressRec rec) {
		recs.add(rec);
	}

	public AddressRec get(int index) {
		if (index < 0 || index >= recs.size())
			return null;
		return recs.get(index);
	}

	/**
	 * кол-во добавленных записей
	 */
	public int size() {
		return recs.size();
	}

	public List<AddressRec> find(String searchStr) {

		searchStr = searchStr.trim();

		List<AddressRec> out = new ArrayList<>();

		// поиск
		for (AddressRec rec : recs)
			if (rec.isValid(searchStr))
				out.add(rec);

		return out;
	}

	public List<AddressRec> getAll() {
		ArrayList<AddressRec> copy = new ArrayList<>(recs);
		return copy;
	}

	/**
	 * Очистить хранилище
	 */
	public void clear() {
		recs.clear();
	}

}
