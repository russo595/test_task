package util;

import java.io.File;

public class FileUtil {

	public static String getFileType(File file) {
		return getFileType(file.getName());
	}

	/**
	 * получить тип файла из пути
	 * 
	 * @param path
	 *            - "путь/имя.тип"
	 * @return "тип", либо null если не нашел точку в конце строки
	 */
	public static String getFileType(String path) {
		int lastDot = path.lastIndexOf('.');
		if (lastDot < 0)
			return null;
		else
			return path.substring(lastDot + 1);
	}

}
