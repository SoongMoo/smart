package repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import Model.LibraryDTO;

public class LibraryRepository {
	@Autowired
	SqlSession sqlSession;
	String namespace = "mappers.libraryMapper";
	String statement;
	public void libCount(String noticeNo) {
		statement = namespace + ".libCount";
		sqlSession.update(statement, noticeNo);
	}
	public LibraryDTO libraryInfo(String noticeNo) {
		statement = namespace + ".libraryInfo";
		return sqlSession.selectOne(statement, noticeNo);
	}
	public List<LibraryDTO> libSelect(){
		statement = namespace + ".libSelect";
		return sqlSession.selectList(statement);
	}
	public void libWrite(LibraryDTO dto) {
		statement = namespace + ".libWrite";
		sqlSession.insert(statement, dto);
	}
	
}
