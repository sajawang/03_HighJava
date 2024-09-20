package kr.or.ddit.dao;

import java.util.List;

import kr.or.ddit.vo.MathSettingVO;
import kr.or.ddit.vo.QuestionVO;

public interface IMathSettingDao {
	/**
	 * 10분수학 생성 - 학생 기능  - 파라미터 MathVO
	 * @param  MathVO mathVo 
	 * @return	성공  : 1 / 실패 : 0
	 */
	public int insertMathSet(MathSettingVO mathVo);
	
	/**
	 * 10분수학 문제 관리 - 관리자 기능  - 
	 * @param  MathVO / QuestionVO
	 * @return	성공  : 1 / 실패 : 0
	 */
	public int updateQueSet(MathSettingVO mathVo,QuestionVO queVo);
	
	/**
	 * 1학생이 직접 수정하는 10분수학  - 학생기능 -
	 * @param  MathVO mathVo 
	 * @return	성공  : 1 / 실패 : 0
	 */
	public int selfUpdateMath(MathSettingVO mathVo);
	
	/**
	 * 10분수학 삭제 - 학생 관리자 기능
	 * @param  int mathNo (10분수학 설정번호)
	 * @return	성공  : 1 / 실패 : 0
	 */	
	public int deleteMathSet(int mathNo);
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public String getSysdateLog(String id);
	
	//0914수정
	/**
	 * 아이디에 따른 선택학년,선택난이도 들고오는(10분 수학 문제 가져오기용)
	 * @param cusid 회원아이디
	 * @return 선택학년,선택난이도
	 */
	public MathSettingVO getMathSetting(String cusid);
	
	//0919수정
	/**
	 * 아이디,설정시간,선택학년,선택난이도,개인정보수집동의를 insert하는 
	 * @param mathVo 5가지 항목의 mathsettingvo
	 * @return 성공1, 실패0
	 */
	public int insertTenMin(MathSettingVO mathVo);
	
	//---------------------------------------------------------------
	//매니저 10분수학
	/**
	 * mathsetting테이블의 모든 데이터 검색
	 * @return list출력
	 */
	public List<MathSettingVO> getAllMathSetting();
}
