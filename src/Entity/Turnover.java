/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author KietHV
 */
public class Turnover {

	String idOrder;
	private String IDProduct;
	private String ProductName;
	private int QuantitySold;
	private Double Turnover;

	public Turnover() {
	}

	public Turnover(String idOrder,String IDProduct, String ProductName, int QuantitySold, Double Turnover) {
		this.idOrder = idOrder;
		this.IDProduct = IDProduct;
		this.ProductName = ProductName;
		this.QuantitySold = QuantitySold;
		this.Turnover = Turnover;
	}

	public String getIdOrder() {
		return idOrder;
	}

	public void setIdOrder(String idOrder) {
		this.idOrder = idOrder;
	}
	
	public String getIDProduct() {
		return IDProduct;
	}

	public void setIDProduct(String IDProduct) {
		this.IDProduct = IDProduct;
	}

	public String getProductName() {
		return ProductName;
	}

	public void setProductName(String ProductName) {
		this.ProductName = ProductName;
	}

	public int getQuantitySold() {
		return QuantitySold;
	}

	public void setQuantitySold(int QuantitySold) {
		this.QuantitySold = QuantitySold;
	}

	public Double getTurnover() {
		return Turnover;
	}

	public void setTurnover(Double Turnover) {
		this.Turnover = Turnover;
	}

}
