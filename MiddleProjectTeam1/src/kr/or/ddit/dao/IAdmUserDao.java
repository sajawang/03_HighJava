package kr.or.ddit.dao;


import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.CustomerVO;
import kr.or.ddit.vo.MemberVO;

public interface IAdmUserDao {

	
	public int insertCusStudent(CustomerVO vo);
	
	
	
	public int insertMemStudent(MemberVO svo);
	
	
	public int updateCusStudent(CustomerVO cusvo);

	
	public int updateMemStudent(MemberVO memvo);
	
	public List<MemberVO>  memAuth();
	
	


	public int deleteMemStudent(String cusId);
	

	public List<MemberVO> getAllStudent(String cusId);
	

	
	public MemberVO getAllMemVo(String cusId);
	
	
	public CustomerVO getAllCusVo(String cusId);
	
	public int countStudent(String cusId);
	
	//학생에서 -> 선생님으로 바뀌는 것
	public int updateUpgrade(CustomerVO cusvo);
	
	//학생 yn 가져오기 
	public List<CustomerVO> cusdelstudent();
	
	public int deleteCusUser(String cusId);
	
	
}
