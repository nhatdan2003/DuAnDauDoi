package Entity;

/**
 *
 * @author haoireal
 */
public class OrderDetails {
	int idOrderDetails;
	String idProduct;
	String idOrder;
	int quantity;
	String idPromo;
	double totalPrice;

	public int getIdOrderDetails() {
		return idOrderDetails;
	}

	public void setIdOrderDetails(int idOrderDetails) {
		this.idOrderDetails = idOrderDetails;
	}

	public String getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(String idProduct) {
		this.idProduct = idProduct;
	}

	public String getIdOrder() {
		return idOrder;
	}

	public void setIdOrder(String idOrder) {
		this.idOrder = idOrder;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getIdPromo() {
		return idPromo;
	}

	public void setIdPromo(String idPromo) {
		this.idPromo = idPromo;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	
}
