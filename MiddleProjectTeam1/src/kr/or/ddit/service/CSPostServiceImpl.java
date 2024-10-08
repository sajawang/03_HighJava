package kr.or.ddit.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.dao.CSPostDaoImpl;
import kr.or.ddit.dao.ICSPostDao;
import kr.or.ddit.vo.CommentVO;
import kr.or.ddit.vo.FileVO;
import kr.or.ddit.vo.PageVO;
import kr.or.ddit.vo.PostVO;

public class CSPostServiceImpl implements ICSPostService {
	
	private ICSPostDao dao;
	private static CSPostServiceImpl service;
	
	private CSPostServiceImpl() {
		dao = CSPostDaoImpl.getInstance();
	}
	public static CSPostServiceImpl getInstance() {
		if(service==null) service= new CSPostServiceImpl();
		return service;
	}
	
	@Override
	public PostVO selectDetailPost(Map<String, Object> map) {
		
		return dao.selectDetailPost(map);
	}

	@Override
	public int insertCsPost(PostVO pvo) {
		// TODO Auto-generated method stub
		return dao.insertCsPost(pvo);
	}

	@Override
	public int updateCsPost(PostVO vo) {

		return dao.updateCsPost(vo);
	}

	@Override
	public int deleteCsPost(PostVO pvo) {
		// TODO Auto-generated method stub
		return dao.deleteCsPost(pvo);
	}

	@Override
	public int updateHitAdminInquiries(PostVO vo) {
		// TODO Auto-generated method stub
		return dao.updateHitAdminInquiries(vo);
	}

	@Override
	public List<PostVO> selectPostList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return dao.selectPostList(map);
	}

	@Override
	public int insertCsComment(CommentVO comVO) {
		// TODO Auto-generated method stub
		return dao.insertCsComment(comVO);
	}

	@Override
	public List<CommentVO> selectComment(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return dao.selectComment(map);
	}

	@Override
	public CommentVO selectDetailComment(int comNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateComment(CommentVO comVO) {
		// TODO Auto-generated method stub
		return dao.updateComment(comVO);
	}

	@Override
	public int deleteComment(int comNo) {
		// TODO Auto-generated method stub
		return dao.deleteComment(comNo);
	}
	@Override
	public PageVO pageInfo(int board_no, int page, String stype, String sword) {
		PageVO pvo = new PageVO();
		//map설정
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("stype", stype);
		map.put("sword", sword);
		map.put("board_no", board_no);
		
		//전체글갯수 가져오기
		int count = this.countBoard(map);
		
		//전체페이지수 구하기
		int perList = PageVO.getPerList();
		int totalPage = (int)Math.ceil(count / (double)perList) ;
		
		//마지막페이지에서 마지막 데이터를 지웠을 때
		//page변수는 7(마지막페이지) - totalPage = 6으로 바뀜
		if(page > totalPage) page = totalPage;
		
		
		//start, end
		int start = (page-1) * perList +1;
		int end = start + perList -1;
		
		if(count < end)end=count;
		
		//startPage, endPage 1 2 / 3 4 / 5 6 / 7 8 /
		int perPage = PageVO.getPerPage();
		
		int startPage = ((page-1) / perPage * perPage)+1;
		int endPage = startPage + perPage-1;
		if(endPage > totalPage) endPage=totalPage;
		
		pvo.setStart(start);
		pvo.setEnd(end);
		pvo.setStartPage(startPage);
		pvo.setEndPage(endPage);
		pvo.setTotalPage(totalPage);
		
		return pvo;
	}
	@Override
	public int countBoard(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return dao.countBoard(map);
	}
	@Override
	public int insertFiles(FileVO fvo) {
		// TODO Auto-generated method stub
		return dao.insertFiles(fvo);
	}
	@Override
	public int updatePostFileNo(String saveFileName) {
		// TODO Auto-generated method stub
		return dao.updatePostFileNo(saveFileName);
	}
	@Override
	public FileVO fileinfo(String saveFileName) {

		return dao.fileinfo(saveFileName);
	}
	
}
