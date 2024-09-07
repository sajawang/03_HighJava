package kr.or.ddit.service;

import java.util.List;

import kr.or.ddit.dao.LprodDaoImpl;
import kr.or.ddit.vo.LprodVO;

public class LprodServiceImpl implements ILprodService {
	//싱글톤2
	private static LprodServiceImpl service;
	public static LprodServiceImpl getService() {
		if(service==null) service= new LprodServiceImpl();
		return service;
	}
	
	//dao연결2-프라이빗 클래스이름 다오, 생성자처럼(프라이빗-클래스이름-)-다오호출을 dao에 넣는다.
	private LprodDaoImpl dao;
	private LprodServiceImpl() {
		dao=LprodDaoImpl.getDao();
	}
	@Override
	public List<LprodVO> selectLprodList() {
		// TODO Auto-generated method stub
		return dao.selectLprodList();
	}

}
