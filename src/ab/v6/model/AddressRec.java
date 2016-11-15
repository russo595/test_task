package ab.v6.model;

import java.io.Serializable;

public class AddressRec implements Serializable {

	private static final long serialVersionUID = 1L;

	private String owner;
	private String address;

	public AddressRec() {
	}

	public AddressRec(String owner, String address) {
		setOwner(owner);
		setAddress(address);
	}

	public void setOwner(String owner) {
		this.owner = owner.trim();
	}

	public void setAddress(String address) {
		this.address = address.trim();
	}

	public String getOwner() {
		return owner;
	}

	public String getAddress() {
		return address;
	}

	public boolean isValid(String searchStr) {
		return owner.contains(searchStr) || address.contains(searchStr);
	}

	@Override
	public String toString() {
		return owner + ", " + address;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((owner == null) ? 0 : owner.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AddressRec other = (AddressRec) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (owner == null) {
			if (other.owner != null)
				return false;
		} else if (!owner.equals(other.owner))
			return false;
		return true;
	}

}
