package Model;
/// 디비에 값을 전달하거나  디비로 부터 값을 받아오기 위해서 생성
public class GoodsDTO {
	Long prodNum;
	String prodName;
	Long prodPrice;
	String prodImage;
	String prodDetail;
	String prodCapacity;
	String prudSupplyer;
	Long prodDelFee;
	String recommend;
	String employeeId;
	String ctgr;
	public Long getProdNum() {
		return prodNum;
	}
	public void setProdNum(Long prodNum) {
		this.prodNum = prodNum;
	}
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public Long getProdPrice() {
		return prodPrice;
	}
	public void setProdPrice(Long prodPrice) {
		this.prodPrice = prodPrice;
	}
	public String getProdImage() {
		return prodImage;
	}
	public void setProdImage(String prodImage) {
		this.prodImage = prodImage;
	}
	public String getProdDetail() {
		return prodDetail;
	}
	public void setProdDetail(String prodDetail) {
		this.prodDetail = prodDetail;
	}
	public String getProdCapacity() {
		return prodCapacity;
	}
	public void setProdCapacity(String prodCapacity) {
		this.prodCapacity = prodCapacity;
	}
	public String getPrudSupplyer() {
		return prudSupplyer;
	}
	public void setPrudSupplyer(String prudSupplyer) {
		this.prudSupplyer = prudSupplyer;
	}
	public Long getProdDelFee() {
		return prodDelFee;
	}
	public void setProdDelFee(Long prodDelFee) {
		this.prodDelFee = prodDelFee;
	}
	public String getRecommend() {
		return recommend;
	}
	public void setRecommend(String recommend) {
		this.recommend = recommend;
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getCtgr() {
		return ctgr;
	}
	public void setCtgr(String ctgr) {
		this.ctgr = ctgr;
	}
}
