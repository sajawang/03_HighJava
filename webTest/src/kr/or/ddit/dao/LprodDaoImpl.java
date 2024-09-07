package kr.or.ddit.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.util.MybatisUtil;
import kr.or.ddit.vo.LprodVO;

public class LprodDaoImpl implements ILproadDao {
	
	//싱글톤만들기2
	private static LprodDaoImpl dao;
	public static LprodDaoImpl getDao() {
		if(dao==null) dao= new LprodDaoImpl();
	return dao;
	}
	
	//생성자만들기1
	private LprodDaoImpl() {}
	
	@Override
	public List<LprodVO> selectLprodList() {
		//변수선언2(리턴값, sqlsession)
		List<LprodVO> list = null;
		SqlSession sql = null;
		
		//try-catch-finally
		try {//mybatis, 쿼리실행 sql.selectList
			sql=MybatisUtil.getSqlSession();
			list=sql.selectList("lprod.selectLprodList");
		} catch (Exception e) {//1개 printstacktrace
			e.printStackTrace();
		} finally {//2개 sql.commit, sql.close()
			sql.close();
		}
		return list;
	}

}























