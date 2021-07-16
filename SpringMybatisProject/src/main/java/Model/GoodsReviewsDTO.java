package Model;

import java.util.List;

public class GoodsReviewsDTO {
	GoodsDTO goods;    /// 1   : 부모글 
	List<ReviewDTO> reviews;   /// n  : 답글
	public GoodsDTO getGoods() {
		return goods;
	}
	public void setGoods(GoodsDTO goods) {
		this.goods = goods;
	}
	public List<ReviewDTO> getReviews() {
		return reviews;
	}
	public void setReviews(List<ReviewDTO> reviews) {
		this.reviews = reviews;
	}
}
