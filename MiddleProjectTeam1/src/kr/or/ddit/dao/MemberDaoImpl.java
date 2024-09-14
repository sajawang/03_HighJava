package kr.or.ddit.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.dao.IMemberDao;
import kr.or.ddit.util.MybatisUtil;
import kr.or.ddit.vo.AttemptVO;
import kr.or.ddit.vo.MaterialVO;
import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.ViewListVO;

public class MemberDaoImpl implements IMemberDao {
	
	
	
	private static MemberDaoImpl dao;
	private MemberDaoImpl() {}
	public static MemberDaoImpl getInstance() {
		if(dao==null) dao = new MemberDaoImpl();
		return dao;
	}
	
	@Override
	public ViewListVO findViewList(String userId, int mateNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AttemptVO wrongAns(List<Integer> myAnswer, int mateNo) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	//0913수정
	@Override
	public int updateMember(MemberVO memVo) {
		SqlSession session = null;  
		int cnt=0;
		try {
			session = MybatisUtil.getSqlSession();
			cnt = session.update("memberMypage.updateMember", memVo);
			System.out.println("커스터머다오"+cnt);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null) session.close();
		} 
		return cnt;
	}

	@Override
	public int findPoint(String userId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int pointAilas(String userId, int point) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getPoint(ViewListVO listVo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<MaterialVO> selectMaterial(String mateTitle) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	//0913수정
	@Override
	public MemberVO getMember(String memId) {
		SqlSession session = null;  
		MemberVO vo = null;
		try {
			session = MybatisUtil.getSqlSession();
			vo = session.selectOne("memberMypage.getMember", memId);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null) session.close();
		} 
		return vo;
	}
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	

}
