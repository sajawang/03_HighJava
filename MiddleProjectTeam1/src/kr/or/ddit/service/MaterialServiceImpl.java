package kr.or.ddit.service;

import java.util.List;

import kr.or.ddit.dao.IMaterialDao;
import kr.or.ddit.dao.MaterialDaoImpl;
import kr.or.ddit.vo.MaterialVO;
import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.ViewListVO;

public class MaterialServiceImpl implements IMaterialService {
	private IMaterialDao dao;	
	private MaterialServiceImpl() {
		dao = MaterialDaoImpl.getInstance();
	}
	private static MaterialServiceImpl service;
	public static MaterialServiceImpl getInstance() {
		if(service==null) service = new MaterialServiceImpl();
		return service;
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

	@Override
	public List<ViewListVO> getViewMaterial(String cusid) {
		// TODO Auto-generated method stub
		return dao.getViewMaterial(cusid);
	}
	@Override
	public List<ViewListVO> getMyMaterial(String cusid) {
		// TODO Auto-generated method stub
		return dao.getMyMaterial(cusid);
	}

}
