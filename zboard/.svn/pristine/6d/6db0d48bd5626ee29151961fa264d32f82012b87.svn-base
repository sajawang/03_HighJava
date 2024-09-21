package kr.or.ddit.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.util.MybatisUtil;
import kr.or.ddit.vo.CommentVO;
import kr.or.ddit.vo.FileVO;
import kr.or.ddit.vo.PageVO;
import kr.or.ddit.vo.PostVO;

public class CSPostDaoImpl implements ICSPostDao {
	private static CSPostDaoImpl dao;
	
	private CSPostDaoImpl() { 	}
	
	public static CSPostDaoImpl getInstance() {
		if(dao==null) dao= new CSPostDaoImpl();
		
		return dao;
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
	public int insertCsPost(PostVO pvo) {

		int cnt = 0;
		SqlSession sql = null;
		
		try {
			sql= MybatisUtil.getSqlSession();
			cnt =sql.insert("cs.insertCsPost",pvo);
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
	public int updateCsPost(PostVO pvo) {
		
		int cnt = 0;
		SqlSession sql = null;
		
		try {
			sql= MybatisUtil.getSqlSession();
			cnt =sql.insert("cs.updateCsPost",pvo);
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
	public int deleteCsPost(PostVO pvo) {
		
		int cnt = 0;
		SqlSession sql = null;
		
		try {
			sql= MybatisUtil.getSqlSession();
			cnt =sql.insert("cs.deleteCsPost",pvo);
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
	public int updateHitAdminInquiries(PostVO vo) {
		int cnt = 0;
		
		SqlSession sql = null;
		
		try {
			sql= MybatisUtil.getSqlSession();
			cnt =sql.insert("cs.updateHitAdminInquiries",vo);
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
	public List<PostVO> selectPostList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		
		List<PostVO> list = null;
		
		
		try (SqlSession sql = MybatisUtil.getSqlSession();){
			
			list = sql.selectList("cs.selectPostList", map);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public int insertCsComment(CommentVO comVO) {
		int cnt = 0;
		
		SqlSession sql = null;
		
		try {
			sql= MybatisUtil.getSqlSession();
			cnt =sql.insert("cs.insertCsComment",comVO);
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
			cnt =sql.insert("cs.updateComment",comVO);
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
			cnt =sql.insert("cs.deleteComment",comNo);
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

}
