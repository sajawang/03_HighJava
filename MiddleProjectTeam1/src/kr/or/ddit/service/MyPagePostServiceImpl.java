package kr.or.ddit.service;

import java.util.List;

import kr.or.ddit.dao.IMyPagePostDao;
import kr.or.ddit.dao.MyPagePostDaoImpl;
import kr.or.ddit.vo.PostVO;

public class MyPagePostServiceImpl implements IMyPagePostService {
	private IMyPagePostDao dao;	
	private MyPagePostServiceImpl() {
		dao = MyPagePostDaoImpl.getInstance(); // DAO객체 생성
	}
	private static MyPagePostServiceImpl service;
	
	public static MyPagePostServiceImpl getInstance() {
		if(service==null) service = new MyPagePostServiceImpl();
		return service;
	}
	
	@Override
	public List<PostVO> getAllBoardThree(String cusid) {
		// TODO Auto-generated method stub
		return dao.getAllBoardThree(cusid);
	}

	@Override
	public List<PostVO> getAllBoardTwo(String cusid) {
		// TODO Auto-generated method stub
		return dao.getAllBoardTwo(cusid);
	}

}
