package kr.or.ddit.dao;

import java.util.List;

import kr.or.ddit.vo.LprodVO;

public interface ILproadDao {
		//리스트가져오기
		public List<LprodVO> selectLprodList();
}
