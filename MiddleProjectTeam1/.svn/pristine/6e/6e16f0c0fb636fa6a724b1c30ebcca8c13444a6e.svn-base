package kr.or.ddit.service;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import kr.or.ddit.dao.AdmNoticeDaoImpl;
import kr.or.ddit.dao.IAdmNoticeDao;
import kr.or.ddit.vo.FileVO;
import kr.or.ddit.vo.PostVO;

public class AdmNoticeServiceImpl implements IAdmNoticeService {

	private IAdmNoticeDao dao;
	
	private static AdmNoticeServiceImpl service;
	
	private AdmNoticeServiceImpl() {
		dao=AdmNoticeDaoImpl.getInstance();
	}
	
	public static AdmNoticeServiceImpl getInstance() {
		if(service==null) service = new AdmNoticeServiceImpl();
		return service;
	}

	@Override
	public List<PostVO> selectNoticeList(int num) {
		return dao.selectNoticeList(num);
	}

	@Override
	public int countNotice(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return dao.countNotice(map);
	}

	@Override
	public int insertNotice(PostVO vo) {
		// TODO Auto-generated method stub
		return dao.insertNotice(vo);
	}

	@Override
	public int deleteNotice(PostVO pvo) {
		// TODO Auto-generated method stub
		return dao.deleteNotice(pvo);
	}

	@Override
	public int updateNotice(PostVO vo) {
		// TODO Auto-generated method stub
		return dao.updateNotice(vo);
	}

	@Override
	public PostVO selectDetailNotice(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return dao.selectDetailNotice(map);
	}

	@Override
	public List<FileVO> selectFile() {
	  
	 return dao.selectFile();      
	    }

	@Override
	public int insertFile(FileVO vo) {
		// TODO Auto-generated method stub
		return dao.insertFile(vo);
	}
	
}
