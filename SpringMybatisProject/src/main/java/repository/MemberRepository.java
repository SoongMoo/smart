package repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import Model.MemberDTO;

public class MemberRepository {
	@Autowired
	SqlSession sqlSession;
	
	String namespace = "mappers.memberMapper";
	String statement;
	public String idFind(MemberDTO dto) {
		statement = namespace + ".idFind";
		return sqlSession.selectOne(statement, dto);
	}
	public int updateCkOk(MemberDTO dto) {
		statement = namespace +".updateCkOk";
		return sqlSession.update(statement, dto);
	}
	public void memDelete(String memId) {
		statement = namespace +".memDelete";
		sqlSession.delete(statement, memId);
	}
	public void memPwUpdate(MemberDTO dto) {
		statement = namespace +".memPwUpdate";
		sqlSession.update(statement, dto);
	}
	public MemberDTO memInfo(String memId) {
		statement = namespace + ".memInfo";
		return sqlSession.selectOne(statement, memId);
	}	
	public void memDel(String memId) {
		statement = namespace +".memDel";
		sqlSession.delete(statement, memId);
	}
	public void memUpdate(MemberDTO dto) {
		statement = namespace + ".memUpdate";
		sqlSession.update(statement, dto);
	}
	public List<MemberDTO> memList(String memId) {
		statement = namespace +".memList";
		return sqlSession.selectList(statement,memId);
	}
	public void memJoin(MemberDTO dto) {
		statement = namespace + ".memJoin";
		sqlSession.insert(statement, dto);
	}
}
