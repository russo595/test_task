package ab.v6.store;

import java.io.File;
import java.io.IOException;

public abstract class AbstractStorage<T> implements Storage<T> {

	protected final File file;

	public AbstractStorage(File file) {

		if (file.isDirectory())
			throw new IllegalArgumentException("Нужен файл, не папка: " + file);

		this.file = file;
	}

	@Override
	public void clear() {
		file.delete();
	}

	@Override
	public final void save(T updated) throws IOException {

		// создаем папки родителей, если нужно
		file.getParentFile().mkdirs();

		doSave(updated);

	}

	protected abstract void doSave(T updated) throws IOException;

}
