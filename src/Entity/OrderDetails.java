package Entity;

import java.util.Date;

/**
 *
 * @author haoireal
 */
public class OrderDetails {
	int idOrderDetails;
	String idProduct;
	String idOrder;
	int quantity;
	double totalPrice;
	Date timeOD;

	public Date getTimeOD() {
		return timeOD;
	}

	public void setTimeOD(Date timeOD) {
		this.timeOD = timeOD;
	}

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


	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	
}
