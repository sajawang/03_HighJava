package kr.or.ddit.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.util.MybatisUtil;
import kr.or.ddit.vo.CommentVO;
import kr.or.ddit.vo.PostVO;

public class AdminSamTalkDaoImpl implements IAdminSamTalkDao {

	private static AdminSamTalkDaoImpl dao;

	private AdminSamTalkDaoImpl() {
	}

	public static AdminSamTalkDaoImpl getInstance() {
		if (dao == null)
			dao = new AdminSamTalkDaoImpl();
		return (AdminSamTalkDaoImpl) dao;
	}
	
	//
	@Override
	public List<PostVO> selectTeacherTalkList(int num) {
		// 1.변수 선언
		List<PostVO> TalkPostList = null;
		SqlSession sql = null;
		// 2.실행
		try {
			sql = MybatisUtil.getSqlSession();

			TalkPostList = sql.selectList("admintalk.selectTeacherTalkList", num);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sql.commit();
			sql.close();
		}
		return TalkPostList;
	}

	@Override
	public int countTeacherTalk(Map<String, Object> map) {
		// 1.변수 선언
		int cnt = 0;
		SqlSession sql = null;
		// 2.실행
		try {
			sql = MybatisUtil.getSqlSession();
			cnt = sql.selectOne("admintalk.countTeacherTalk", map);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sql.commit();
			sql.close();
		}
		// 3.cnt리턴
		return cnt;
	}

	@Override
	public int deleteTeacherTalk(PostVO pvo) {
		// 1.변수 선언
		int cnt = 0;
		SqlSession sql = null;
		// 2.실행
		try {
			sql = MybatisUtil.getSqlSession();
			cnt = sql.delete("admintalk.deleteTeacherTalk", pvo);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sql.commit();
			sql.close();
		}

		// 3.cnt리턴
		return cnt;
	}

	@Override
	public List<CommentVO> selectTeacherCommentList(int num) {
		// 1.변수 선언
		List<CommentVO> CommentList = null;
		SqlSession sql = null;
		// 2.실행
		try {
			sql = MybatisUtil.getSqlSession();

			CommentList = sql.selectList("admintalk.selectTeacherCommentList", num);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sql.close();
		}
		return CommentList;
	}

	@Override
	public int delectTeacherComment(CommentVO cvo) {
		// 1.변수 선언
		int cnt = 0;
		SqlSession sql = null;
		// 2.실행
		try {
			sql = MybatisUtil.getSqlSession();
			cnt = sql.update("admintalk.delectTeacherComment", cvo);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sql.commit();
			sql.close();
		}

		// 3.cnt리턴
		return cnt;
	}

	
	//페이징 처리하는 곳
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
