package kr.or.ddit.service;

import java.util.List;

import kr.or.ddit.vo.QuestionVO;

public interface IQuestionService {
	
	/**
	 * 학습지 문제 풀기 - 학생 기능
	 * @param String ans (입력한 정답)
	 * @return 성공  : 1 / 실패 : 0
	 */
	public int studyQuestion(String ans);
	
	/**
	 * 학습지 풀이 및 채점 , 배점 관리 이건 관리자 역할
	 * @param QuestionVO queVo (문제 Vo)
	 * @return 성공  : 1 / 실패 : 0
	 */
	public int updateQuestion(QuestionVO queVo);
	
	/**
	 * 학습지 정답 및 해설 작성 - 관리자 역할 
	 * @param QuestionVO queVo
	 * @return 성공  : 1 / 실패 : 0
	 */
	public int insertQuestion(QuestionVO queVo);
	
	/**
	 * 회원이 풀이한 문제의 해설과 정답이 출력됨. - 시스템 기능
	 * @param String find (입력한 정답)
	 * @return 성공  : QuestionVO의 정답, 해설 / 실패 : 0
	 */
	public QuestionVO selectQuestion(String find);
	
	/**
	 * 학습지번호를 매개변수로 받아서 학습지의 문제, 정답 및 해설을 가지고오는 메서드
	 * 
	 * @param mateNo 학습지번호
	 * @return 학습지문제, 정답 및 해설을 가진 QuestionVO객체를 담은 List객체
	 */
	public List<QuestionVO> getAnswerList(int mateNo);
	
}
