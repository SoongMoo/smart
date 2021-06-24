package controller.venta;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DAO.SalesDAO;
import model.DTO.DeliveryDTO;

public class DeliveryOkPage {
	public void execute(HttpServletRequest request,
			HttpServletResponse response) {
		DeliveryDTO dto = new DeliveryDTO();
		dto.setArrivalExpDate(
				request.getParameter("ArrivalExpDate"));
		dto.setDeliveryCom(
				request.getParameter("deliveryCom"));
		dto.setDeliveryDelFree(
				request.getParameter("deliveryDelFree"));
		dto.setDeliveryExpDate(
				request.getParameter("deliveryExpDate"));
		dto.setDeliveryNum(
				request.getParameter("deliveryNum"));
		dto.setPurchaseNum(
				request.getParameter("purchaseNum"));
		SalesDAO dao = new SalesDAO();
		dao.deliveryCreate(dto);
		try {
			PrintWriter out= response.getWriter();
			out.println("<script>");
			out.println("self.close();");
			out.println("</script>");
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
