package kr.or.ddit.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.dao.AdmMyMathBoardDaoImpl;
import kr.or.ddit.dao.AdminInquiriesDaoImpl;
import kr.or.ddit.vo.CommentVO;
import kr.or.ddit.vo.FileVO;
import kr.or.ddit.vo.PageVO;
import kr.or.ddit.vo.PostVO;

public class AdmMyMathBoardServiceImpl implements IAdmMyMathBoardService {
	
	private AdmMyMathBoardDaoImpl dao;
	private static AdmMyMathBoardServiceImpl service;
	
	private AdmMyMathBoardServiceImpl() {
		dao = AdmMyMathBoardDaoImpl.getInstance();
	}
	public static AdmMyMathBoardServiceImpl getInstance() {
		if(service==null) service= new AdmMyMathBoardServiceImpl();
		return service;
	}
	@Override
	public int countBoard(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return dao.countBoard(map);
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
	public List<PostVO> selectPostList() {
		// TODO Auto-generated method stub
		return dao.selectPostList();
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
	

}
