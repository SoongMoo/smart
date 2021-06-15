package model.DAO;

import model.DTO.AuthInfo;

public class LoginDAO extends DataBaseInfo{
	public AuthInfo login(String userId) {
		AuthInfo authInfo = new AuthInfo();
		sql = " select mem_id , mem_pw , '일반' "
			+ " from member "
			+ " where mem_id = ? "
			+ " union "
			+ " select EMP_USERID, EMP_PW, EMPLOYEE_ID "
			+ " from employees"
			+ " where EMP_USERID = ?";
		return authInfo;
	}
}
