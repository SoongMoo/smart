package repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import Model.GoodsDTO;

public class GoodsRepository {
	@Autowired
	SqlSession sqlSession;
	String namespace = "mappers.goodsMapper";
	String statement;
	public List<GoodsDTO> goodsList() {
		statement = namespace + ".goodsList";
		return sqlSession.selectList(statement);
	}
	public void goodsWrite(GoodsDTO dto) {
		statement = namespace + ".goodsWrite";
		sqlSession.insert(statement, dto);
	}
	public int goodsNum() {
		statement = namespace + ".goodsNum";
		return sqlSession.selectOne(statement);
	}
}
