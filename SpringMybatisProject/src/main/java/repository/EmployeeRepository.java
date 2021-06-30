package repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

public class EmployeeRepository {
	@Autowired
	SqlSession sqlSession;
	String namespace = "mappers.employeeMapper"; 
	public String empNo() {
		return null;
	}
}
