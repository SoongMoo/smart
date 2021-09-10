package service.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import Model.AuthInfoDTO;
@Repository
public class LogInRepository {
	@Autowired
	SqlSession sqlSession;
	String namespace  = "mappers.LogInMapper";
	String statement; 
	public AuthInfoDTO logIn(String userId) {
		statement = namespace +".logIn";
		return sqlSession.selectOne(statement, userId);
	}
}
