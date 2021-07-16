package Model;

import java.util.Date;

public class PaymentDTO {
	String purchaseNum;
	String memId;
	String paymentMethod;
	String paymentApprPrice;
	String paymentApprNum;
	Date paymentApprDate;
	String paymentNumber;
	public String getPurchaseNum() {
		return purchaseNum;
	}
	public void setPurchaseNum(String purchaseNum) {
		this.purchaseNum = purchaseNum;
	}
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public String getPaymentApprPrice() {
		return paymentApprPrice;
	}
	public void setPaymentApprPrice(String paymentApprPrice) {
		this.paymentApprPrice = paymentApprPrice;
	}
	public String getPaymentApprNum() {
		return paymentApprNum;
	}
	public void setPaymentApprNum(String paymentApprNum) {
		this.paymentApprNum = paymentApprNum;
	}
	public Date getPaymentApprDate() {
		return paymentApprDate;
	}
	public void setPaymentApprDate(Date paymentApprDate) {
		this.paymentApprDate = paymentApprDate;
	}
	public String getPaymentNumber() {
		return paymentNumber;
	}
	public void setPaymentNumber(String paymentNumber) {
		this.paymentNumber = paymentNumber;
	}
	
}
