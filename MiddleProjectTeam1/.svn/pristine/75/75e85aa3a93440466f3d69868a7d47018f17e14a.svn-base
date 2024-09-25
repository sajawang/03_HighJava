package kr.or.ddit.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.util.MybatisUtil;
import kr.or.ddit.vo.FileVO;
import kr.or.ddit.vo.PostVO;

public class AdminTeacherLibraryDaoImpl implements IAdminTeacherLibraryDao {
	private static AdminTeacherLibraryDaoImpl dao;

	private AdminTeacherLibraryDaoImpl() {

	}

	public static AdminTeacherLibraryDaoImpl getInstance() {
		if (dao == null)
			dao = new AdminTeacherLibraryDaoImpl();
		return (AdminTeacherLibraryDaoImpl) dao;
	}

	@Override
	public List<PostVO> selectLibraryList(int num) {
		// 1.변수 선언
		List<PostVO> LibraryList = null;
		SqlSession sql = null;
		// 2.실행
		try {
			sql = MybatisUtil.getSqlSession();

			LibraryList = sql.selectList("library.selectLibraryList", num);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sql.commit();
			sql.close();
		}
		return LibraryList;
	}

	@Override
	public int countLibrary(Map<String, Object> map) {
		// 1.변수 선언
		int cnt = 0;
		SqlSession sql = null;
		// 2.실행
		try {
			sql = MybatisUtil.getSqlSession();
			cnt = sql.selectOne("library.countLibrary", map);

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
	public int insertLibrary(PostVO vo) {
		// 1.변수 선언
		int cnt = 0;
		SqlSession sql = null;
		// 2.실행
		try {
			sql = MybatisUtil.getSqlSession();
			cnt = sql.insert("library.insertLibrary", vo);

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
	public int deleteLibrary(PostVO pvo) {
		// 1.변수 선언
		int cnt = 0;
		SqlSession sql = null;
		// 2.실행
		try {
			sql = MybatisUtil.getSqlSession();
			cnt = sql.delete("library.deleteLibrary", pvo);

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
	public int updateLibrary(PostVO vo) {
		// 1.변수 선언
		int cnt = 0;
		SqlSession sql = null;
		// 2.실행
		try {
			sql = MybatisUtil.getSqlSession();
			cnt = sql.update("library.updateLibrary", vo);

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
	public PostVO selectDetailLibrary(Map<String, Object> map) {
		// 1.변수 선언
		PostVO vo = null;
		SqlSession sql = null;
		// 2.실행
		try {
			sql = MybatisUtil.getSqlSession();
			vo = sql.selectOne("library.selectDetailLibrary", map);

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
			fileList = sql.selectList("library.selectFile");

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
			cnt = sql.insert("library.insertFile", vo);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sql.commit();
			sql.close();
		}

		// 3.cnt리턴
		return cnt;
	}

	// 페이징처리
	@Override
	public List<PostVO> getAllAdminTeacherLib(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int countAdminTeacherLiv(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public PostVO getPostWithFile(int num) {
		// 1.변수 선언
		PostVO getPost = null;
		SqlSession sql = null;
		// 2.실행
		try {
			sql = MybatisUtil.getSqlSession();

			getPost = sql.selectOne("library.selectPostWithFile", num);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sql.commit();
			sql.close();
		}
		return getPost;

	}
}