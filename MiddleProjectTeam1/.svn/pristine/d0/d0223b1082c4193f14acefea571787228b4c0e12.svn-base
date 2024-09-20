package kr.or.ddit.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.util.MybatisUtil;
import kr.or.ddit.vo.PostVO;

public class MyPagePostDaoImpl implements IMyPagePostDao {

	private static MyPagePostDaoImpl dao;
	private MyPagePostDaoImpl() {}
	
	
	public static MyPagePostDaoImpl getInstance() {
		if(dao==null) dao = new MyPagePostDaoImpl();
		return dao;
	}
	
	@Override
	public List<PostVO> getAllBoardThree(String cusid) {
		SqlSession sql = null;
		List<PostVO> list = null;
		try {
			sql=MybatisUtil.getSqlSession();
			list=sql.selectList("memberMypageBoard.getAllBoardThree",cusid);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			 if (sql != null) { // Check if sql is not null before calling methods on it
		           // sql.commit();
		            sql.close();
		        }
		}
		return list;
	}


	@Override
	public List<PostVO> getAllBoardTwo(String cusid) {
		SqlSession sql = null;
		List<PostVO> list = null;
		try {
			sql=MybatisUtil.getSqlSession();
			list=sql.selectList("memberMypageBoard.getAllBoardTwo",cusid);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			 if (sql != null) { // Check if sql is not null before calling methods on it
		           // sql.commit();
		            sql.close();
		        }
		}
		return list;
	}

}
