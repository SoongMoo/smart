package model.DAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.DTO.ClientSaleDTO;
import model.DTO.CustomerTotalDTO;

public class SalesDAO extends DataBaseInfo {
	public List<CustomerTotalDTO> customerTotal(){
		List<CustomerTotalDTO> list =
				new ArrayList<CustomerTotalDTO>();
		sql =" select  m.mem_Id, mem_name , sum(purchase_tot_price),"
			+"	count(*), avg(purchase_tot_price)"
			+"    from member m, purchase pu"
			+"    where m.mem_id = pu.mem_id"
			+"    group by m.mem_Id, m.mem_name";
		getConnect();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				CustomerTotalDTO dto = new CustomerTotalDTO();
				dto.setCount(rs.getString(4));
				dto.setMemId(rs.getString(1));
				dto.setMemName(rs.getString(2));
				dto.setSumPrice(rs.getString(3));
				dto.setAvg(rs.getString(5));
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return list;
	}
	public List<ClientSaleDTO> salesList(String memId){
		System.out.println("adadad" + memId);
		List<ClientSaleDTO> list = new ArrayList<ClientSaleDTO>();
		sql = "select m.mem_id, mem_name, mem_phone," 
		    +"    pr.prod_num, prod_name," 
		    +"    pu.purchase_num, purchase_date, PURCHASE_ADDR ," 
		    +"    RECEIVER_NAME , RECEIVER_PHONE, "
		    +"    PURCHASE_QTY ,  PURCHASE_PRICE "
		    +"  from member m, purchase pu, products pr,  "
		    +"	     purchase_list pl "
			+"  where m.mem_id(+) = pu.mem_id "
			+"    and pu.purchase_num = pl.purchase_num"
			+"    and pl.prod_num = pr.prod_num";
		if(memId != null) {
			sql += " and m.mem_id = ?";
		}
		System.out.println(sql);
		getConnect();
		try {
			pstmt = conn.prepareStatement(sql);
			if(memId != null) {
				pstmt.setString(1, memId);
			}
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ClientSaleDTO dto = new ClientSaleDTO();
				dto.setMemId(rs.getString("mem_Id"));
				dto.setMemName(rs.getString("mem_Name"));
				dto.setMemPhone(rs.getString("mem_Phone"));
				dto.setProdName(rs.getString("prod_Name"));
				dto.setProdNum(rs.getString("prod_Num"));
				dto.setPurchaseAddr(rs.getString("purchase_Addr"));
				dto.setPurchaseDate(rs.getDate("purchase_Date"));
				dto.setPurchaseNum(rs.getString("purchase_Num"));
				dto.setPurchasePrice(rs.getString("purchase_Price"));
				dto.setPurchaseQty(rs.getString("purchase_Qty"));
				dto.setReceiverName(rs.getString("receiver_Name"));
				dto.setReceiverPhone(rs.getString("receiver_Phone"));
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return list;
	}
}
