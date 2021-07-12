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
	public void goodsUpdate(GoodsDTO dto) {
		statement = namespace +".goodsUpdate";
		sqlSession.update(statement, dto);
	}
	public GoodsDTO goodsDetail(String prodNum) {
		statement = namespace + ".goodsDetail";
		return sqlSession.selectOne(statement, prodNum) ;
	}
	public List<GoodsDTO> goodsList(){
		statement = namespace + ".goodsList";
		return sqlSession.selectList(statement);
	}
	public void goodsInsert(GoodsDTO dto) {
		statement = namespace + ".goodsInsert";
		sqlSession.insert(statement, dto);
	}
	public String goodsNum() {
		statement = namespace + ".goodsNum";
		return sqlSession.selectOne(statement);
	}
}
