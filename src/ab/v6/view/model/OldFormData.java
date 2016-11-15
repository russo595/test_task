package ab.v6.view.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class OldFormData implements Serializable {

	private static final long serialVersionUID = 1L;

	public String error;
	public Map<String, String> vals = new HashMap<>();

	public String getError() {
		return error;
	}

	public Map<String, String> getVals() {
		return vals;
	}

}
