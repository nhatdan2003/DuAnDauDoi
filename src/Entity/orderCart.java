package Entity;
import java.util.HashMap;
/**
 *
 * @author haoireal
 */
public class orderCart {
	String idProductDTO;
	HashMap<String, ProductDTO> cartDetails;

	public orderCart(){
		cartDetails = new HashMap<>();
	}
	
	public String getIdProductDTO() {
		return idProductDTO;
	}

	public void setIdProductDTO(String idOrder) {
		this.idProductDTO = idOrder;
	}

	public HashMap<String, ProductDTO> getCartDetails() {
		return cartDetails;
	}

	public void setCartDetails(HashMap<String, ProductDTO> cartDetails) {
		this.cartDetails = cartDetails;
	}
	
	public void addProductDTO(ProductDTO pd) {
        String idPd = pd.getPd().getIdProduct();
        // nếu tồn tại SP trong giỏ hàng thì cộng thêm số lượng mua mới vào
        if (cartDetails.containsKey(idPd)) {
            // soLuong = soLuongCu + soLuongMoi
            int quantity = cartDetails.get(idPd).getQuantity() + pd.getQuantity();
            // cập nhật lại số lượng:
            cartDetails.get(idPd).setQuantity(quantity);
        } else { // nếu SP chưa có trong giỏ hàng thì put mới vào hashmap
            cartDetails.put(idPd, pd);
        }
    }
	public boolean removeProduct(String idPd) {
        // kiểm tra SP nếu tồn tại thì remove khỏi hashmap
        if (cartDetails.containsKey(idPd)) {
            cartDetails.remove(idPd);
            return true;
        } else { 
            return false;
        }
    }
	
}
