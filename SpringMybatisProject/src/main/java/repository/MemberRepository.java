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
	public List<MemberDTO> memList(String memId) {
		statement = namespace +".memList";
		return sqlSession.selectList(statement,memId);
	}
	public void memJoin(MemberDTO dto) {
		statement = namespace + ".memJoin";
		sqlSession.insert(statement, dto);
	}
}
