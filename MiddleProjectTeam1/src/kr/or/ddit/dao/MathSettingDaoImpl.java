package kr.or.ddit.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.util.MybatisUtil;
import kr.or.ddit.vo.MathSettingVO;
import kr.or.ddit.vo.QuestionVO;

public class MathSettingDaoImpl implements IMathSettingDao {
	private static MathSettingDaoImpl dao;
	private MathSettingDaoImpl() {}
	public static MathSettingDaoImpl getInstance() {
		if(dao==null) dao = new MathSettingDaoImpl();
		return dao;
	}
	
	@Override
	public int insertMathSet(MathSettingVO mathVo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateQueSet(MathSettingVO mathVo, QuestionVO queVo) {
		return 0;
	}

	@Override
	public int selfUpdateMath(MathSettingVO mathVo) {
		SqlSession session = null;  
		int cnt=0;
		try {
			session = MybatisUtil.getSqlSession();
			cnt = session.update("memberMypageTenMinMath.selfUpdateMath", mathVo);
			System.out.println(" 다오"+cnt);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(cnt>0) {
			session.commit();
			}
			if(session!=null) session.close();
		} 
		return cnt;
	}

	@Override
	public int deleteMathSet(int mathNo) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	   public String getSysdateLog(String id) {
	      SqlSession sql = null;
	      String str = null;
	      try {
	         sql=MybatisUtil.getSqlSession();
	         
	         str=sql.selectOne("member.getViewMaterial",id);
	         
	         if(str==null) {
	            System.out.println("str 널");
	         }
	         
	      } catch (Exception e) {
	         e.printStackTrace();
	      } finally {
	         sql.commit();
	         sql.close();
	      }
	      
	      return str;
	   }
	
	@Override
	public MathSettingVO getMathSetting(String cusid) {
		SqlSession session = null;  
		MathSettingVO mvo = null;
		try {
			session = MybatisUtil.getSqlSession();
			mvo = session.selectOne("memberMypageTenMinMath.getMathSetting", cusid);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.commit();
			session.close();
		} 
		return mvo;
	}
	@Override
	public int insertTenMin(MathSettingVO mathVo) {
		SqlSession session = null;  
		int cnt=0;
		try {
			session = MybatisUtil.getSqlSession();
			cnt = session.update("memberMypageTenMinMath.insertTenMin", mathVo);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.commit();
			if(session!=null) session.close();
		} 
		return cnt;
	}
	@Override
	public List<MathSettingVO> getAllMathSetting() {
		SqlSession session = null;  
		List<MathSettingVO> list = null;
		try {
			session = MybatisUtil.getSqlSession();
			list = session.selectList("managertenminmath.getAllMathSetting");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.commit();
			session.close();
		} 
		return list;
	}

}
