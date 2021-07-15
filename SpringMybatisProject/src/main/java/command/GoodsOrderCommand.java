package command;

public class GoodsOrderCommand {
	String receiveName;
	String purchaseAddr;
	String purchasePhone;
	String purchaseRequest;
	String prodNums;
	String purchaseTotPrice;
	String purchaseMethod;
	public String getReceiveName() { // 멤버필드가 가지고 있는 값을 전달해 주기 위해서
		return receiveName;
	}
	public void setReceiveName(String receiveName) { // 멤버필드를 초기화하기 위해서
		this.receiveName = receiveName;
	}
	public String getPurchaseAddr() {
		return purchaseAddr;
	}
	public void setPurchaseAddr(String purchaseAddr) {
		this.purchaseAddr = purchaseAddr;
	}
	public String getPurchasePhone() {
		return purchasePhone;
	}
	public void setPurchasePhone(String purchasePhone) {
		this.purchasePhone = purchasePhone;
	}
	public String getPurchaseRequest() {
		return purchaseRequest;
	}
	public void setPurchaseRequest(String purchaseRequest) {
		this.purchaseRequest = purchaseRequest;
	}
	public String getProdNums() {
		return prodNums;
	}
	public void setProdNums(String prodNums) {
		this.prodNums = prodNums;
	}
	public String getPurchaseTotPrice() {
		return purchaseTotPrice;
	}
	public void setPurchaseTotPrice(String purchaseTotPrice) {
		this.purchaseTotPrice = purchaseTotPrice;
	}
	public String getPurchaseMethod() {
		return purchaseMethod;
	}
	public void setPurchaseMethod(String purchaseMethod) {
		this.purchaseMethod = purchaseMethod;
	}
}
