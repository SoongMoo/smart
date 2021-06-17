package model.DAO;

import java.sql.SQLException;

public class GoodsDAO extends DataBaseInfo{
	public String goodsNum() {
		String prodNum = null;
		sql = "select prod_seq.nextval from dual";
		getConnect();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			prodNum = rs.getString(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return prodNum;
	}
}
