package kr.or.ddit.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.dao.AdminInquiriesDaoImpl;
import kr.or.ddit.dao.CSPostDaoImpl;
import kr.or.ddit.dao.IAdminInquiriesDAO;
import kr.or.ddit.dao.ICSPostDao;
import kr.or.ddit.vo.CommentVO;
import kr.or.ddit.vo.FileVO;
import kr.or.ddit.vo.PageVO;
import kr.or.ddit.vo.PostVO;

public class AdminInquiriesServiceImpl implements IAdminInquiriesService {
	
	private AdminInquiriesDaoImpl dao;
	private static AdminInquiriesServiceImpl service;
	
	private AdminInquiriesServiceImpl() {
		dao = AdminInquiriesDaoImpl.getInstance();
	}
	public static AdminInquiriesServiceImpl getInstance() {
		if(service==null) service= new AdminInquiriesServiceImpl();
		return service;
	}
	@Override
	public int countBoard(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return dao.countBoard(map);
	}
	@Override
	public PageVO pageInfo(int page, String stype, String sword) {
		PageVO pvo = new PageVO();
		//map설정
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("stype", stype);
		map.put("sword", sword);
		map.put("board_no", 3);
		
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
	public PostVO selectDetailPost(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return dao.selectDetailPost(map);
	}
	@Override
	public int insertPost(PostVO pvo) {
		// TODO Auto-generated method stub
		return dao.insertPost(pvo);
	}
	@Override
	public int updatePost(PostVO vo) {
		// TODO Auto-generated method stub
		return dao.updatePost(vo);
	}
	@Override
	public int deletePost(PostVO vo) {
		// TODO Auto-generated method stub
		return dao.deletePost(vo);
	}
	@Override
	public List<PostVO> selectPostList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return dao.selectPostList(map);
	}
	@Override
	public int insertComment(CommentVO comVO) {
		// TODO Auto-generated method stub
		return dao.insertComment(comVO);
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
		// TODO Auto-generated method stub
		return dao.fileinfo(saveFileName);
	}
<<<<<<< .mine
	@Override
	public List<PostVO> getAllBoardThree(String cusid) {
		// TODO Auto-generated method stub
		return null;
	}
	
||||||| .r443686
	
=======
	@Override
	public PostVO postView(int post_no) {
		// TODO Auto-generated method stub
		return dao.postView(post_no);
	}
	@Override
	public List<CommentVO> commentView(int post_no) {
		// TODO Auto-generated method stub
		return dao.commentView(post_no);
	}
>>>>>>> .r444302

}
