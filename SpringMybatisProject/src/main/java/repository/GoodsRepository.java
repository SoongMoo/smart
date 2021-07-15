package repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import Model.CartDTO;
import Model.GoodsDTO;
import Model.ProductCartDTO;

public class GoodsRepository {
	@Autowired
	SqlSession sqlSession;
	String namespace = "mappers.goodsMapper";
	String statement;
	public void goodsQtyDown(CartDTO dto) {
		statement = namespace + ".goodsQtyDown";
		sqlSession.update(statement, dto);
	}
	public ProductCartDTO cartList(CartDTO dto) {
		statement = namespace + ".cartList";
		return sqlSession.selectOne(statement, dto);
	}
	public List<String> memProdNum(String memId){
		statement = namespace + ".memProdNum";
		return sqlSession.selectList(statement,memId);
	}
	public int cartAdd(CartDTO dto) {
		statement = namespace + ".cartAdd";
		return sqlSession.insert(statement, dto);
	}
	public void goodsDel(String prodNum) {
		statement = namespace +".goodsDel";
		sqlSession.delete(statement, prodNum);
	}
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
