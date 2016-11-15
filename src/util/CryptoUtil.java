package util;

import java.util.Base64;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class CryptoUtil {

	public static String sha256Hash(String key, String val) throws Exception {

		Mac mac = Mac.getInstance("HmacSHA256");
		SecretKeySpec secret_key = new SecretKeySpec(key.getBytes("UTF-8"), "HmacSHA256");
		mac.init(secret_key);

		byte[] bytes = mac.doFinal(val.getBytes("UTF-8"));

		String out = Base64.getEncoder().encodeToString(bytes);

		return out;
	}

}
