package kr.or.ddit.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.dao.AdmUserDaoImpl;
import kr.or.ddit.dao.IAdmUserDao;
import kr.or.ddit.vo.CustomerVO;
import kr.or.ddit.vo.MemberVO;

public class AdmUserServiceImpl implements IAdmUserService{

	private IAdmUserDao dao;
	
	private static AdmUserServiceImpl service;
	
	private AdmUserServiceImpl() {
		dao=AdmUserDaoImpl.getInstance();
	}
	public static AdmUserServiceImpl getInstance() {
		if(service==null) service = new AdmUserServiceImpl();
		return service;
	}
	@Override
	public int insertCusStudent(CustomerVO vo) {
		// TODO Auto-generated method stub
		return dao.insertCusStudent(vo);
	}
	@Override
	public int insertMemStudent(MemberVO svo) {
		// TODO Auto-generated method stub
		return dao.insertMemStudent(svo);
	}
	@Override
	public int updateCusStudent(CustomerVO cusvo) {
		// TODO Auto-generated method stub
		return dao.updateCusStudent(cusvo);
	}
	@Override
	public int updateMemStudent(MemberVO memvo) {
		// TODO Auto-generated method stub
		return dao.updateMemStudent(memvo);
	}
	@Override
	public int deleteCusUser(String cusId) {
		// TODO Auto-generated method stub
		return dao.deleteCusUser(cusId);
	}
	@Override
	public int deleteMemStudent(String cusId) {
		// TODO Auto-generated method stub
		return dao.deleteMemStudent(cusId);
	}
	@Override
	public List<MemberVO> getAllStudent(String cusId) {
		// TODO Auto-generated method stub
		return dao.getAllStudent(cusId);
	}

	@Override
	public int countStudent(String cusId) {
		// TODO Auto-generated method stub
		return dao.countStudent(cusId);
	}
	@Override
	public MemberVO getAllMemVo(String cusId) {
		// TODO Auto-generated method stub
		return dao.getAllMemVo(cusId);
	}
	@Override
	public CustomerVO getAllCusVo(String cusId) {
		// TODO Auto-generated method stub
		return dao.getAllCusVo(cusId);
	}
	@Override
	public List<MemberVO> memAuth() {
		// TODO Auto-generated method stub
		return dao.memAuth();
	}
	@Override
	public int updateUpgrade(CustomerVO cusvo) {
		// TODO Auto-generated method stub
		return dao.updateUpgrade(cusvo);
	}
	@Override
	public List<CustomerVO> cusdelstudent() {
		// TODO Auto-generated method stub
		return dao.cusdelstudent();
	}
	

	
}
