package ab.v6.store;

import java.io.IOException;

public interface Storage<T> {

	T load(Class<T> type) throws IOException;

	void save(T updated) throws IOException;

	void clear();

}
