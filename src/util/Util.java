package util;

import java.util.Collection;
import java.util.HashMap;

import org.apache.log4j.Logger;

public class Util {

	public static Logger getLog(Class<?> type) {
		return Logger.getLogger(type);
	}

	public static boolean isEmpty(Object o) {
		return o == null;
	}

	public static boolean isEmpty(Collection<?> col) {
		return col == null || col.size() == 0;
	}

	public static boolean isEmpty(String str) {
		return str == null || str.length() == 0;
	}

	public static <K, V> HashMap<K, V> map() {
		return new HashMap<K, V>();
	}

	public static <K, V> HashMap<K, V> map(K key, V val) {
		HashMap<K, V> out = new HashMap<>();
		out.put(key, val);
		return out;
	}

	public static <K, V> HashMap<K, V> map(K key1, V val1, K key2, V val2) {
		HashMap<K, V> out = new HashMap<>();
		out.put(key1, val1);
		out.put(key2, val2);
		return out;
	}

}
