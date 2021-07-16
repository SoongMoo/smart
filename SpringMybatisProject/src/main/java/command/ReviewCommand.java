package command;

import org.springframework.web.multipart.MultipartFile;

public class ReviewCommand {
	String prodNum;
	String purchaseNum;
	String reviewContent;
	MultipartFile reviewImg;
	public String getProdNum() {
		return prodNum;
	}
	public void setProdNum(String prodNum) {
		this.prodNum = prodNum;
	}
	public String getPurchaseNum() {
		return purchaseNum;
	}
	public void setPurchaseNum(String purchaseNum) {
		this.purchaseNum = purchaseNum;
	}
	public String getReviewContent() {
		return reviewContent;
	}
	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}
	public MultipartFile getReviewImg() {
		return reviewImg;
	}
	public void setReviewImg(MultipartFile reviewImg) {
		this.reviewImg = reviewImg;
	}
}
