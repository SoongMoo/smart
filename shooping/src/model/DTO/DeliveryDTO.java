package model.DTO;

public class DeliveryDTO {
	String purchaseNum;
	String deliveryCom;
	String deliveryNum;
	String deliveryExpDate;
	String ArrivalExpDate;
	String deliveryDelFree;
	public String getPurchaseNum() {
		return purchaseNum;
	}
	public void setPurchaseNum(String purchaseNum) {
		this.purchaseNum = purchaseNum;
	}
	public String getDeliveryCom() {
		return deliveryCom;
	}
	public void setDeliveryCom(String deliveryCom) {
		this.deliveryCom = deliveryCom;
	}
	public String getDeliveryNum() {
		return deliveryNum;
	}
	public void setDeliveryNum(String deliveryNum) {
		this.deliveryNum = deliveryNum;
	}
	public String getDeliveryExpDate() {
		return deliveryExpDate;
	}
	public void setDeliveryExpDate(String deliveryExpDate) {
		this.deliveryExpDate = deliveryExpDate;
	}
	public String getArrivalExpDate() {
		return ArrivalExpDate;
	}
	public void setArrivalExpDate(String arrivalExpDate) {
		ArrivalExpDate = arrivalExpDate;
	}
	public String getDeliveryDelFree() {
		return deliveryDelFree;
	}
	public void setDeliveryDelFree(String deliveryDelFree) {
		this.deliveryDelFree = deliveryDelFree;
	} 
}
