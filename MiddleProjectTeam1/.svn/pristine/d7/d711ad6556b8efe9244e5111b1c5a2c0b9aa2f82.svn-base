package kr.or.ddit.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.util.MybatisUtil;
import kr.or.ddit.vo.AttemptVO;
import kr.or.ddit.vo.MaterialVO;
import kr.or.ddit.vo.ViewListVO;
import kr.or.ddit.vo.MathSettingVO;
import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.ViewListVO;

public class MaterialDaoImpl implements IMaterialDao{
	private static MaterialDaoImpl dao = new MaterialDaoImpl();
	
	private MaterialDaoImpl() { }
	
	public static MaterialDaoImpl getInstance() { return dao; }

	@Override
	public int InsertMaterial(MaterialVO mateVo) {
		return 0;
	}

	@Override
	public List<MaterialVO> selectMaterial(Map<String, Object> map) {
		SqlSession session = null;
		List<MaterialVO> list = null;
		
		try {
			session = MybatisUtil.getSqlSession();
			
			list = session.selectList("material.selectMaterial", map);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null) session.close();
		}
		
		return list;
	}

	@Override
	public MaterialVO selectDetailMaterial(int mateNo) {
		SqlSession session = null;
		MaterialVO vo = null;
		
		try {
			session = MybatisUtil.getSqlSession();
			
			vo = session.selectOne("material.selectDetailMaterial", mateNo);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null) session.close();
		}
		
		return vo;
	}

	@Override
	public int UpdateMaterial(MaterialVO mateVo) {
		return 0;
	}

	@Override
	public int DeleteMaterial(int mateNo) {
		return 0;
	}

	@Override
	public List<MaterialVO> getMaterQuestionFile(int mateNo) {
		SqlSession session = null;
		List<MaterialVO> list = null;
		
		try {
			session = MybatisUtil.getSqlSession();
			
			list = session.selectList("material.getMaterQuestionFile", mateNo);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null) session.close();
		}
		
		return list;
	}

	@Override
	public int insertViewList(Map<String, Object> map) {
		SqlSession session = null;
		int cnt = 0;
		
		try {
			session = MybatisUtil.getSqlSession();
			
			cnt = session.insert("material.insertViewList", map);
			if(cnt > 0) session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null) session.close();
		}
		
		return cnt;
	}

	@Override
	public int insertAttempt(AttemptVO vo) {
		SqlSession session = null;
		int cnt = 0;
		
		try {
			session = MybatisUtil.getSqlSession();
			
			cnt = session.insert("material.insertAttempt", vo);
			if(cnt > 0) session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null) session.close();
		}
		
		return cnt;
	}

	@Override
	public int countMaterial(Map<String, Object> map) {
		SqlSession session = null;
		int cnt = 0;
		
		try {
			session = MybatisUtil.getSqlSession();
			
			cnt = session.selectOne("material.countMaterial", map);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null) session.close();
		}
		return cnt;
	}

	@Override
	public List<MaterialVO> firstMaterial(Map<String, Object> map) {
		SqlSession session = null;
		List<MaterialVO> list = null;
		
		try {
			session = MybatisUtil.getSqlSession();
			
			list = session.selectList("material.firstMaterial", map);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null) session.close();
		}
		return list;
	}
	
	//0914추가
	@Override
	public List<ViewListVO> getViewMaterial(String cusid) {
	  SqlSession sql = null;
	  List<ViewListVO> mlist = null;
	  try {
	     sql=MybatisUtil.getSqlSession();
	     
	     mlist=sql.selectList("memberMypageTenMinMath.getViewMaterial",cusid);
	 
	      } catch (Exception e) {
	         e.printStackTrace();
	      } finally {
	         sql.commit();
	         sql.close();
	      }
	      
	      return mlist;
	}
	
	
	@Override
	public List<ViewListVO> getMyMaterial(String cusid) {
		  SqlSession sql = null;
		  List<ViewListVO> mlist = null;
		  try {
		     sql=MybatisUtil.getSqlSession();
		     
		     mlist=sql.selectList("memberMypageMaterial.getMyMaterial",cusid);
		 
		      } catch (Exception e) {
		         e.printStackTrace();
		      } finally {
		         sql.commit();
		         sql.close();
		      }
		      
		      return mlist;
		}
	@Override
	public int updateMemberPoint(MemberVO mvo) {
		SqlSession session = null;
		int cnt = 0;
		
		try {
			session = MybatisUtil.getSqlSession();
			
			cnt = session.update("material.updateMemberPoint", mvo);
			if(cnt>0) session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null) session.close();
		}
		return cnt;
	}

	@Override
	public MathSettingVO getMathMinute(String cusId) {
		SqlSession session = null;
		MathSettingVO vo = null;
		
		try {
			session = MybatisUtil.getSqlSession();
			
			vo = session.selectOne("material.getMathMinute", cusId);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null) session.close();
		}
		return vo;
	}

	@Override
	public List<ViewListVO> getMyAnswer(ViewListVO vo) {
		SqlSession session = null;
		List<ViewListVO> list = null;
		
		try {
			session = MybatisUtil.getSqlSession();
			
			list = session.selectList("material.getMyAnswer", vo);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null) session.close();
		}
		return list;
	}
	
	//추가0921
	@Override
	public MaterialVO todayTenMinMaterial(Map<String, Object> map) {
		SqlSession sql = null;
		MaterialVO mvo= null;
	  try {
	     sql=MybatisUtil.getSqlSession();
	     
	     mvo=sql.selectOne("memberMypageTenMinMath.todayTenMinMaterial",map);
	 
	      } catch (Exception e) {
	         e.printStackTrace();
	      } finally {
	         sql.commit();
	         sql.close();
	      }
	      
	      return mvo;
	}
	
}
