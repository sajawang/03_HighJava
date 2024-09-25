package kr.or.ddit.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.dao.AdmTeacherDaoImpl;
import kr.or.ddit.dao.IAdmTeacherDao;
import kr.or.ddit.vo.CustomerVO;
import kr.or.ddit.vo.MemberVO;

public class AdmTeacherServiceImpl implements IAdmTeacherService{

		private IAdmTeacherDao dao;
		
		private static AdmTeacherServiceImpl service;
		
		private AdmTeacherServiceImpl() {
			dao= AdmTeacherDaoImpl.getInstance();
		}
		public static AdmTeacherServiceImpl getInstance() {
			if(service==null) service = new AdmTeacherServiceImpl();
			return service;
		}
	
		@Override
		public int insertCusTeacher(CustomerVO cusvo) {
			// TODO Auto-generated method stub
			return dao.insertCusTeacher(cusvo);
		}
		@Override
		public int insertMemTeacher(MemberVO mvo) {
			// TODO Auto-generated method stub
			return dao.insertMemTeacher(mvo);
		}
	
	
		@Override
		public  List<MemberVO> getAllTeacher(String cusId) {
			// TODO Auto-generated method stub
			return dao.getAllTeacher(cusId);
		}
		
		@Override
		public int updateMemTeacher(MemberVO mvo) {
			// TODO Auto-generated method stub
			return dao.updateMemTeacher(mvo);
		}
		@Override
		public int updateCusTeacher(CustomerVO cusvo) {
			// TODO Auto-generated method stub
			return dao.updateCusTeacher(cusvo);
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
		public List<CustomerVO> cusdelteacher() {
			// TODO Auto-generated method stub
			return dao.cusdelteacher();
		}
	
		
	

}
