package repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import Model.NoticeDTO;


public class NoticeRepository {
	@Autowired
	SqlSession sqlSession;
	String namespace = "mappers.noticeMapper";
	String statement;
	public void noticeDel(String noticeNo) {
		statement = namespace +".noticeDel";
		sqlSession.delete(statement, noticeNo);
	}
	public void noticeModify(NoticeDTO dto) {
		statement = namespace + ".noticeModify";
		sqlSession.update(statement, dto);
	}
	public NoticeDTO noticeDetail(String noticeNo) {
		statement = namespace + ".noticeDetail";
		return sqlSession.selectOne(statement, noticeNo);
	}
	public void noticeReadUpdate(String noticeNo) {
		statement = namespace + ".noticeCount";
		sqlSession.update(statement, noticeNo);
	}
	public List<NoticeDTO> noticeList(){
		statement = namespace + ".noticeList";
		return sqlSession.selectList(statement);
	}
	public void noticeWrite(NoticeDTO dto) {
		statement = namespace + ".noticeWrite";
		sqlSession.insert(statement, dto);
	}
}