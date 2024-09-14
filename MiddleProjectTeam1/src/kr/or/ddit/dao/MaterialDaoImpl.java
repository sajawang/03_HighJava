package kr.or.ddit.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.util.MybatisUtil;
import kr.or.ddit.vo.MaterialVO;
import kr.or.ddit.vo.MemberVO;

public class MaterialDaoImpl implements IMaterialDao {
	private static MaterialDaoImpl dao;
	private MaterialDaoImpl() {}
	public static MaterialDaoImpl getInstance() {
		if(dao==null) dao = new MaterialDaoImpl();
		return dao;
	}
	@Override
	public int InsertMaterial(MaterialVO mateVo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<MaterialVO> selectMaterial() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MaterialVO selectDetailMaterial(int mateNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int UpdateMaterial(MaterialVO mateVo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int DeleteMaterial(int mateNo) {
		// TODO Auto-generated method stub
		return 0;
	}

	//0914추가
	@Override
	public List<MaterialVO> getViewMaterial(String cusid) {
	  SqlSession sql = null;
	  List<MaterialVO> mlist = null;
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

}
