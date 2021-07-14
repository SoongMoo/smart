package Model;

public class ProductCartDTO {
	GoodsDTO productDTO; 
	CartDTO cartDTO;
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
