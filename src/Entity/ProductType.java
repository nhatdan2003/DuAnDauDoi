package Entity;

/**
 *
 * @author haoireal
 */
public class ProductType {
	String IDType;
	String nameType;

	public String getIDType() {
		return IDType;
	}

	public void setIDType(String IDType) {
		this.IDType = IDType;
	}

	public String getNameType() {
		return nameType;
	}

	public void setNameType(String nameType) {
		this.nameType = nameType;
	}
	
	@Override
	public String toString() {
		return this.nameType;
	}
}
