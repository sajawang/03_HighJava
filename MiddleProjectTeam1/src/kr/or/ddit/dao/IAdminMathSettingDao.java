package kr.or.ddit.dao;

import java.util.List;

import kr.or.ddit.vo.MathSettingVO;
import kr.or.ddit.vo.MemberVO;

public interface IAdminMathSettingDao {
		
	//10분 수학 신청학생(customervo) 조회
	public MathSettingVO getCusId(String cusId);
	
	//10분 수학 신청 (mathsetting)모든 조회
	public List<MathSettingVO> getAllStudent(); 
	
	//10분 수학 신청 수정
	public int updateAdminMath(MathSettingVO vo);
	
	//10분 수학 신청 삭제
	public int deleteAdminMath(String cusId);
	
	//학생등록
	public int insertStudent(MathSettingVO vo);
	
	public int saveOrUpdateMathSetting(MathSettingVO vo);
		
}
