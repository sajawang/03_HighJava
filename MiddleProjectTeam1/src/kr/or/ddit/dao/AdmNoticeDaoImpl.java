package kr.or.ddit.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.util.MybatisUtil;
import kr.or.ddit.vo.FileVO;
import kr.or.ddit.vo.PostVO;

public class AdmNoticeDaoImpl implements IAdmNoticeDao {

	private static AdmNoticeDaoImpl dao;

	private AdmNoticeDaoImpl() {
	}

	public static AdmNoticeDaoImpl getInstance() {
		if (dao == null)
			dao = new AdmNoticeDaoImpl();
		return (AdmNoticeDaoImpl) dao;
	}

	@Override
	public List<PostVO> selectNoticeList(int num) {
		// 1.변수 선언
		List<PostVO> noticeList = null;
		SqlSession sql = null;
		// 2.실행

		try {
			sql = MybatisUtil.getSqlSession();

			noticeList = sql.selectList("notice.selectNoticeList", num);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sql.commit();
			sql.close();
		}
		return noticeList;
	}

	@Override
	public int countNotice(Map<String, Object> map) {
		// 1.변수 선언
		int cnt = 0;
		SqlSession sql = null;
		// 2.실행
		try {
			sql = MybatisUtil.getSqlSession();
			cnt = sql.selectOne("notice.countNotice", map);

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
	public int insertNotice(PostVO vo) {
		// 1.변수 선언
		int cnt = 0;
		SqlSession sql = null;
		// 2.실행
		try {
			sql = MybatisUtil.getSqlSession();
			cnt = sql.insert("notice.insertNotice", vo);

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
	public int deleteNotice(PostVO pvo) {
		// 1.변수 선언
		int cnt = 0;
		SqlSession sql = null;
		// 2.실행
		try {
			sql = MybatisUtil.getSqlSession();
			cnt = sql.delete("notice.deleteNotice", pvo);

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
	public int updateNotice(PostVO vo) {
		// 1.변수 선언
		int cnt = 0;
		SqlSession sql = null;
		// 2.실행
		try {
			sql = MybatisUtil.getSqlSession();
			cnt = sql.update("notice.updateNotice", vo);

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
	public PostVO selectDetailNotice(Map<String, Object> map) {
		// 1.변수 선언
		PostVO vo = null;
		SqlSession sql = null;
		// 2.실행
		try {
			sql = MybatisUtil.getSqlSession();
			vo = sql.selectOne("notice.selectDetailNotice", map);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sql.commit();
			sql.close();
		}

		// 3.vo리턴
		return vo;
	}

	@Override
	public List<FileVO> selectFile() {
		// 1. 변수 선언
		List<FileVO> fileList = null;
		SqlSession sql = null;

		// 2. 실행
		try {
			sql = MybatisUtil.getSqlSession();
			fileList = sql.selectList("notice.selectFile");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sql != null) {
				sql.close();
			}
		}
		return fileList;
	}

	@Override
	public int insertFile(FileVO vo) {
		// 1.변수 선언
		int cnt = 0;
		SqlSession sql = null;
		// 2.실행
		try {
			sql = MybatisUtil.getSqlSession();
			cnt = sql.insert("notice.insertFile", vo);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sql.commit();
			sql.close();
		}

		// 3.cnt리턴
		return cnt;

	}
}