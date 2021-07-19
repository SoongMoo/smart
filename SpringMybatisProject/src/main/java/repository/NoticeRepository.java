package repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import Model.NoticeDTO;


public class NoticeRepository {
	@Autowired
	SqlSession sqlSession;
	String namespace = "mappers.noticeMapper";
	String statement;
	public void noticeWrite(NoticeDTO dto) {
		statement = namespace + ".noticeWrite";
		sqlSession.insert(statement, dto);
	}
}