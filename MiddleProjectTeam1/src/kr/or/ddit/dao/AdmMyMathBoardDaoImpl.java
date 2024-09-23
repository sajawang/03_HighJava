package kr.or.ddit.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.util.MybatisUtil;
import kr.or.ddit.vo.CommentVO;
import kr.or.ddit.vo.FileVO;
import kr.or.ddit.vo.PostVO;

public class AdmMyMathBoardDaoImpl implements IAdmMyMathBoardDao {
	
	private static AdmMyMathBoardDaoImpl  dao;

	private AdmMyMathBoardDaoImpl () {
	}

	public static AdmMyMathBoardDaoImpl getInstance() {
		if (dao == null)
			dao = new AdmMyMathBoardDaoImpl ();
		return dao;
	}
	
	@Override
	public int countBoard(Map<String, Object> map) {
		int cnt = 0;
		SqlSession sql = null;
		try {
			sql= MybatisUtil.getSqlSession();
			cnt = sql.selectOne("cs.countPost",map);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			sql.close();
		}
		
		return cnt;
	}

	@Override
	public PostVO selectDetailPost(Map<String, Object> map) {
		PostVO pvo = null;
		
		try(SqlSession sql = MybatisUtil.getSqlSession();) {
			
			pvo = sql.selectOne("cs.selectDetailPost",map);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return pvo;
	}

	@Override
	public int insertPost(PostVO pvo) {
		int cnt = 0;
		SqlSession sql = null;
		
		try {
			sql= MybatisUtil.getSqlSession();
			cnt =sql.insert("adminmymathboard.insertPost",pvo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if(cnt!=0) {
				sql.commit();
				sql.close();
			}
		}
		
		return cnt;
	}

	@Override
	public int updatePost(PostVO vo) {
		int cnt = 0;
		SqlSession sql = null;
		
		try {
			sql= MybatisUtil.getSqlSession();
			cnt =sql.insert("adminmymathboard.updatePost",vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if(cnt!=0) {
				sql.commit();
				sql.close();
			}
		}
		
		return cnt;
	}

	@Override
	public int deletePost(PostVO vo) {
		int cnt = 0;
		SqlSession sql = null;
		
		try {
			sql= MybatisUtil.getSqlSession();
			cnt =sql.insert("adminmymathboard.deletePost",vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if(cnt!=0) {
				sql.commit();
				sql.close();
			}
		}
		
		return cnt;
	}

	@Override
	public List<PostVO> selectPostList() {
		
		List<PostVO> list = null;
		
		
		try (SqlSession sql = MybatisUtil.getSqlSession();){
			
			list = sql.selectList("adminmymathboard.selectPostList");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public int insertComment(CommentVO comVO) {
		int cnt = 0;
		
		SqlSession sql = null;
		
		try {
			sql= MybatisUtil.getSqlSession();
			cnt =sql.insert("adminmymathboard.insertComment",comVO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if(cnt!=0) {
				sql.commit();
				sql.close();
			}
		}
		
		return cnt;
	}

	@Override
	public List<CommentVO> selectComment(Map<String, Object> map) {
		List<CommentVO> list = null;
		
		
		try (SqlSession sql = MybatisUtil.getSqlSession();){
			
			list = sql.selectList("cs.selectComment", map);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public CommentVO selectDetailComment(int comNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateComment(CommentVO comVO) {
		int cnt = 0;
		
		SqlSession sql = null;
		
		try {
			sql= MybatisUtil.getSqlSession();
			cnt =sql.insert("adminmymathboard.updateComment",comVO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if(cnt!=0) {
				sql.commit();
				sql.close();
			}
		}
		
		return cnt;
	}

	@Override
	public int deleteComment(int comNo) {
		int cnt = 0;
		
		SqlSession sql = null;
		
		try {
			sql= MybatisUtil.getSqlSession();
			cnt =sql.insert("adminmymathboard.deleteComment",comNo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if(cnt!=0) {
				sql.commit();
				sql.close();
			}
		}
		
		return cnt;
	}

	@Override
	public int insertFiles(FileVO fvo) {
		int cnt = 0;
		SqlSession sql = null;
		
		try {
			sql = MybatisUtil.getSqlSession();
			cnt = sql.insert("cs.insertFiles", fvo);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if(cnt !=0) {
				sql.commit();
				sql.close();
			}
		}
		
		return cnt;
	}

	@Override
	public int updatePostFileNo(String saveFileName) {
		int cnt = 0;
		SqlSession sql = null;
		
		try {
			sql= MybatisUtil.getSqlSession();
			cnt =sql.insert("cs.updatePostFileNo",saveFileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if(cnt!=0) {
				sql.commit();
				sql.close();
			}
		}
		
		return cnt;
	}

	@Override
	public FileVO fileinfo(String saveFileName) {
		FileVO fvo = null;

		try(SqlSession sql = MybatisUtil.getSqlSession();) {
	
			fvo = sql.selectOne("cs.fileinfo",saveFileName);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return fvo;
	}

	@Override
	public PostVO postView(int post_no) {
		PostVO pvo = null;
		SqlSession sql = null;
		
		try {
			sql = MybatisUtil.getSqlSession();
			pvo = sql.selectOne("adminmymathboard.postView", post_no);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return pvo;
	}

	@Override
	public List<CommentVO> commentView(int post_no) {
		
		List<CommentVO> cvo = null;
		SqlSession sql = null;
		
		try {
			sql = MybatisUtil.getSqlSession();
			cvo = sql.selectList("adminmymathboard.commentView",post_no);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return cvo;
	}
	
	

}