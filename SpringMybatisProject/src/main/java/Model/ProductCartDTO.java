package Model;

public class ProductCartDTO {
	GoodsDTO productDTO;  // 1
	CartDTO cartDTO;    // 1
	public GoodsDTO getProductDTO() {
		return productDTO;
	}
	public void setProductDTO(GoodsDTO productDTO) {
		this.productDTO = productDTO;
	}
	public CartDTO getCartDTO() {
		return cartDTO;
	}
	public void setCartDTO(CartDTO cartDTO) {
		this.cartDTO = cartDTO;
	}
}
