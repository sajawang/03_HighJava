package kr.or.ddit.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.util.MybatisUtil;
import kr.or.ddit.vo.MaterialVO;
import kr.or.ddit.vo.QuestionVO;

public class AdmMaterialDaoImpl implements IAdmMaterialDao {

private static AdmMaterialDaoImpl dao;
	
	private AdmMaterialDaoImpl() { 	}
	
	public static AdmMaterialDaoImpl getInstance() {
		if(dao==null) dao= new AdmMaterialDaoImpl();
		
		return dao;
	}
	
	@Override
	public MaterialVO detailMaterial(int material_no) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertMaterial(MaterialVO vo) {
		SqlSession session=null;
		int cnt = 0;
		
		try {
			session=MybatisUtil.getSqlSession();
			
			cnt=session.insert("material.adminInsertMate", vo);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.commit();
			session.close();
		}
		
		System.out.println("다오"+"1");
		
		return cnt;
	}

	@Override
	public int updateMaterial(MaterialVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteMaterial(int material_no) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<MaterialVO> getAllMaterial() {
		SqlSession session = null;
		List<MaterialVO> list = null;
		
		try {
			session = MybatisUtil.getSqlSession();
			
			list = session.selectList("material.selectMaterial");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null) session.close();
		}
		
		return list;
	}

	@Override
	public int countMaterial(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int adminInsertMateFile(String fileName) {
		SqlSession session=null;
		int cnt = 0;
		
		try {
			session=MybatisUtil.getSqlSession();
			
			cnt=session.insert("material.adminInsertMateFile", fileName);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.commit();
			session.close();
		}
		
		System.out.println("다오"+"1");
		
		return cnt;
	}

	@Override
	public int adminInsertMate(MaterialVO mateVo) {
		SqlSession session=null;
		int cnt = 0;
		
		try {
			session=MybatisUtil.getSqlSession();
			
			cnt=session.insert("material.adminInsertMate", mateVo);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.commit();
			session.close();
		}
		
		System.out.println("다오"+"1");
		
		return cnt;
	}

	@Override
	public Integer adminSelectMateFileNum(String fileName) {
		SqlSession session=null;
		int cnt = 0;
		
		try {
			session=MybatisUtil.getSqlSession();
			
			cnt=session.selectOne("material.adminSelectMateFileNum", fileName);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.commit();
			session.close();
		}
		
		
		return cnt;
	}

	@Override
	public List<QuestionVO> getQuestionList() {
		
		SqlSession session=null;
		List<QuestionVO> list = null;
		int cnt = 0;
		
		try {
			session=MybatisUtil.getSqlSession();
			
			list=session.selectList("material.getQuestionList");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.commit();
			session.close();
		}
		
		return list;
	}

	@Override
	public List<QuestionVO> getMateQuestionList(int mateNo) {

		SqlSession session=null;
		List<QuestionVO> list = null;
		int cnt = 0;
		
		try {
			session=MybatisUtil.getSqlSession();
			
			list=session.selectList("material.getMateQuestionList",mateNo);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.commit();
			session.close();
		}
		
		return list;
	}

	@Override
	public String adminSelectMateFileName(int fileNo) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
