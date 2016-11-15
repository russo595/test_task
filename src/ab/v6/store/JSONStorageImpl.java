package ab.v6.store;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JSONStorageImpl<T> extends AbstractStorage<T> {

	Gson gson;

	public JSONStorageImpl(File file) {
		super(file);

		GsonBuilder builder = new GsonBuilder();
		builder.setPrettyPrinting();
		gson = builder.create();
	}

	@Override
	public T load(Class<T> type) throws IOException {

		try (FileReader reader = new FileReader(file)) {

			return gson.fromJson(reader, type);

		}
	}

	@Override
	protected void doSave(T updated) throws IOException {

		boolean append = false;

		try (FileWriter writer = new FileWriter(file, append)) {

			String str = gson.toJson(updated);
			writer.write(str);

		}

	}

}
