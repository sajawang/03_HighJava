package kr.or.ddit.service;

import java.util.List;

import kr.or.ddit.vo.LprodVO;

public interface ILprodService {

	//리스트가져오기
	public List<LprodVO> selectLprodList();
}
