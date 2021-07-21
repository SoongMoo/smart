package repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import Model.EmployeeDTO;

public class EmployeeRepository {
	@Autowired
	SqlSession sqlSession;
	
	String namespace = "mappers.employeeMapper";
	String statement;
	public void pwUpdate(EmployeeDTO dto) {
		statement = namespace + ".pwUpdate";
		sqlSession.update(statement, dto);
	}
	public void empModify(EmployeeDTO dto) {
		statement = namespace + ".empModify";
		sqlSession.update(statement, dto);
	}
	public EmployeeDTO empDetail(String empId) {
		statement = namespace + ".empDetail";
		return sqlSession.selectOne(statement, empId);
	}
	public void empDelete(String empId) {
		statement = namespace +".empDelete";
		int i = sqlSession.delete(statement, empId);
		System.out.println(i + "개가 삭제되었습니다.");
	}
	public void empUpdate(EmployeeDTO dto) {
		statement = namespace +".empUpdate";
		int i = sqlSession.update(statement,dto);
		System.out.println(i + "개가 수정되었습니다.");
	}
	
	public EmployeeDTO empInfo(String empId) {
		statement = namespace + ".empInfo";
		return sqlSession.selectOne(statement,empId);
	}
	public List<EmployeeDTO> empList(EmployeeDTO dto){
		statement = namespace + ".empList";
		return sqlSession.selectList(statement, dto);
	}
	public int count() {
		statement = namespace + ".count";
		return sqlSession.selectOne(statement);
	}
	public void empInsert(EmployeeDTO dto) {
		statement = namespace + ".empInsert";
		int i = sqlSession.insert(statement,dto);
		System.out.println(i + "개가 저장 되었습니다.");
	}
	public String empNo() {
		statement = namespace + ".empNo";
		return sqlSession.selectOne(statement);
	}
}