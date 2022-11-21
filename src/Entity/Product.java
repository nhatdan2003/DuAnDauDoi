package Entity;

/**
 *
 * @author haoireal
 */
public class Product {

	String idProduct;
	String productName;
	String typePro;
	double price;
	String image;
	String descreption;

	public String getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(String idProduct) {
		this.idProduct = idProduct;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getTypePro() {
		return typePro;
	}

	public void setTypePro(String typePro) {
		this.typePro = typePro;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getDescreption() {
		return this.descreption;
	}

	public void setDescreption(String descreption) {
		this.descreption = descreption;
	}

	
}
