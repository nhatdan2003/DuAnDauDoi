package Entity;

/**
 *
 * @author haoireal
 */
public class ProductDTO {
	Product pd;
	int quantity;

	public ProductDTO() {
	}

	public ProductDTO(Product pd, int quantity) {
		this.pd = pd;
		this.quantity = quantity;
	}

	public Product getPd() {
		return pd;
	}

	public void setPd(Product pd) {
		this.pd = pd;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
}
