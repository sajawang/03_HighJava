package kr.or.ddit.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.dao.AdminSamTalkDaoImpl;
import kr.or.ddit.dao.IAdminSamTalkDao;
import kr.or.ddit.vo.CommentVO;
import kr.or.ddit.vo.PostVO;

public class AdminSamTalkServiceImpl  implements  IAdminSamTalkService{

	private IAdminSamTalkDao dao;
	
	private static AdminSamTalkServiceImpl service;
	
	private AdminSamTalkServiceImpl() {
		dao = AdminSamTalkDaoImpl.getInstance();
	}
	
	public static AdminSamTalkServiceImpl getInstance() {
		if(service ==null)
			service = new AdminSamTalkServiceImpl();
		return service;
	}

	@Override
	public List<PostVO> selectTeacherTalkList(int num) {
		// TODO Auto-generated method stub
		return dao.selectTeacherTalkList(num);
	}

	@Override
	public int countTeacherTalk(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return dao.countTeacherTalk(map);
	}

	@Override
	public int deleteTeacherTalk(PostVO pvo) {
		// TODO Auto-generated method stub
		return dao.deleteTeacherTalk(pvo);
	}

	@Override
	public List<CommentVO> selectTeacherCommentList(int num) {
		// TODO Auto-generated method stub
		return dao.selectTeacherCommentList(num);
	}

	@Override
	public int delectTeacherComment(CommentVO cvo) {
		// TODO Auto-generated method stub
		return dao.delectTeacherComment(cvo);
	}

	@Override
	public List<PostVO> getAllAdminSamTalk(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int countAdminSamTalk(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return 0;
	}
}
