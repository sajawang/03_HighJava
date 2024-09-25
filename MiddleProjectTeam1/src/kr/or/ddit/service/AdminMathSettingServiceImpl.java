package kr.or.ddit.service;

import java.util.List;

import kr.or.ddit.dao.AdminMathSettingDaoImpl;
import kr.or.ddit.dao.IAdminMathSettingDao;
import kr.or.ddit.vo.CustomerVO;
import kr.or.ddit.vo.MathSettingVO;

public class AdminMathSettingServiceImpl implements IAdminMathSettingService  {

	private IAdminMathSettingDao dao;
	private static AdminMathSettingServiceImpl service;
	
	private AdminMathSettingServiceImpl() {
		dao = AdminMathSettingDaoImpl.getInstance();
	}
	
	public static AdminMathSettingServiceImpl getInstance() {
		if(service ==null)
			service = new AdminMathSettingServiceImpl();
		return service;
	}

	@Override
	public List<MathSettingVO> getAllStudent() {
		// TODO Auto-generated method stub
		return dao.getAllStudent();
	}

	@Override
	public int updateAdminMath(MathSettingVO vo) {
		// TODO Auto-generated method stub
		return dao.updateAdminMath(vo);
	}

	@Override
	public int deleteAdminMath(String cusId) {
		// TODO Auto-generated method stub
		return dao.deleteAdminMath(cusId);
	}

	@Override
	public MathSettingVO getCusId(String cusId) {
		// TODO Auto-generated method stub
		return dao.getCusId(cusId);
	}

	@Override
	public int insertStudent(MathSettingVO vo) {
		// TODO Auto-generated method stub
		return dao.insertStudent(vo);
	}
	@Override
	public int saveOrUpdateMathSetting(MathSettingVO vo) {
		return dao.saveOrUpdateMathSetting(vo);
	}
	
	
}
