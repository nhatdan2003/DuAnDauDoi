package Entity;

import java.util.Date;

/**
 *
 * @author haoireal
 */
public class Order {
	String idOrder;
	Date dateOrder;
	Date timeOrder;
	String idPromo;
	Double totalPrice;

	public String getIdPromo() {
		return idPromo;
	}

	public void setIdPromo(String idPromo) {
		this.idPromo = idPromo;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}
	String userName;
	String idTable;
	Boolean statusTable;

	public Boolean getStatusTable() {
		return statusTable;
	}

	public void setStatusTable(Boolean statusTable) {
		this.statusTable = statusTable;
	}

	public String getIdOrder() {
		return idOrder;
	}

	public void setIdOrder(String idOrder) {
		this.idOrder = idOrder;
	}

	public Date getDateOrder() {
		return dateOrder;
	}

	public void setDateOrder(Date dateOrder) {
		this.dateOrder = dateOrder;
	}

	public Date getTimeOrder() {
		return timeOrder;
	}

	public void setTimeOrder(Date timeOrder) {
		this.timeOrder = timeOrder;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getIdTable() {
		return idTable;
	}

	public void setIdTable(String idTable) {
		this.idTable = idTable;
	}
	
	
	
}
