package kr.or.ddit.dao;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.util.MybatisUtil;
import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.PostVO;
import kr.or.ddit.vo.ViewListVO;
import kr.or.ddit.vo.AttemptVO;
import kr.or.ddit.vo.CommentVO;
import kr.or.ddit.vo.CustomerVO;
import kr.or.ddit.vo.FavoriteVO;
import kr.or.ddit.vo.MathSettingVO;

public class CustomerDaoImpl implements ICustomerDao {

	private static CustomerDaoImpl dao;
	
	private CustomerDaoImpl() {}
	
	public static CustomerDaoImpl getInstance() {
		if(dao==null)dao=new CustomerDaoImpl();
		return dao;
	}
	
	@Override
	public String idCheck(String id) {
		String userId = null;
		SqlSession session=null;
		
		try {
			session=MybatisUtil.getSqlSession();
			
			userId=session.selectOne("member.idCheck", id);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.commit();
			session.close();
		}
		
		
		return userId;
	}

	@Override
	public String idFind(MemberVO memVo) {
		String userId = null;
		SqlSession session=null;
		//멤버 이름과 이메일을 받으면 아이디를 반환
		try {
			session=MybatisUtil.getSqlSession();
			
			userId=session.selectOne("member.idFind", memVo);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.commit();
			session.close();
		}
		
		
		return userId;
	}


	@Override
	public int login(CustomerVO userVo) {
		SqlSession session = null;
		int cnt = 0;
		
		try {
			
			session = MybatisUtil.getSqlSession();
			
			cnt=session.insert("member.inmember",userVo);
			
		} catch (Exception e) {
			
		} finally {
			session.commit();
			session.close();
		}
		
		return cnt;
	}

	@Override
	public int insertMember(MemberVO memVo) {
		SqlSession session=null;
		int cnt = 0;
		
		try {
			session=MybatisUtil.getSqlSession();
			
			cnt=session.insert("member.insertMember", memVo);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.commit();
			session.close();
		}
		
		System.out.println("다오"+"1");
		
		return cnt;
	}
	@Override
	public int insertCustomer(CustomerVO cusVo) {
		SqlSession session=null;
		int cnt = 0;
		
		try {
			session=MybatisUtil.getSqlSession();
			
			cnt=session.insert("member.insertCustomer", cusVo);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.commit();
			session.close();
		}
		
		System.out.println("다오"+"2");
		
		return cnt;
	}

	@Override
	public int newPassIdCheck(MemberVO memVo) {
		SqlSession session=null;
		int cnt = 0;
		
		try {
			session=MybatisUtil.getSqlSession();
			
			cnt=session.selectOne("member.newPassIdCheck", memVo);
			
			System.out.println("다오에서 cnt 값 " + cnt);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.commit();
			session.close();
		}
		
		return cnt;
	}


	@Override
	public CustomerVO getLoginUser(CustomerVO cusVo) {
		SqlSession sql = null;
		CustomerVO vo = null;
		try {
			sql=MybatisUtil.getSqlSession();
			
			vo=sql.selectOne("member.getLoginUser",cusVo);
			
			if(vo==null) {
				System.out.println("vo가 널");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sql.commit();
			sql.close();
		}
		
		return vo;
	}

	@Override
	public MemberVO getLoginMemberPoint(MemberVO memVo) {
		SqlSession sql = null;
		MemberVO vo = null;
		try {
			sql=MybatisUtil.getSqlSession();
			
			vo=sql.selectOne("member.getLoginMember",memVo);
			
			if(vo==null) {
				System.out.println("vo가 널");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sql.commit();
			sql.close();
		}
		
		return vo;
	}

	@Override
	public FavoriteVO getFavoriteVO(String id) {
		SqlSession sql = null;
		FavoriteVO vo = null;
		try {
			sql=MybatisUtil.getSqlSession();
			
			vo=sql.selectOne("member.getFavoriteVO",id);
			
			if(vo==null) {
				System.out.println("vo가 널");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sql.commit();
			sql.close();
		}
		
		return vo;
	}

	@Override
	public ViewListVO getViewListVO(String id) {
		SqlSession sql = null;
		ViewListVO vo = null;
		try {
			sql=MybatisUtil.getSqlSession();
			
			vo=sql.selectOne("member.getViewListVO",id);
			
			if(vo==null) {
				System.out.println("vo가 널");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sql.commit();
			sql.close();
		}
		
		return vo;
	}

	@Override
	public PostVO getPostVO(String id) {
		SqlSession sql = null;
		PostVO vo = null;
		try {
			sql=MybatisUtil.getSqlSession();
			
			vo=sql.selectOne("member.getPostVO",id);
			
			if(vo==null) {
				System.out.println("vo가 널");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sql.commit();
			sql.close();
		}
		
		return vo;
	}

	@Override
	public MathSettingVO getMathSettingVO(String id) {
		SqlSession sql = null;
		MathSettingVO vo = null;
		try {
			sql=MybatisUtil.getSqlSession();
			
			vo=sql.selectOne("member.getMathSettingVO",id);
			
			if(vo==null) {
				System.out.println("vo가 널");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sql.commit();
			sql.close();
		}
		
		return vo;
	}

	@Override
	public CommentVO getCommentVO(String id) {
		SqlSession sql = null;
		CommentVO vo = null;
		try {
			sql=MybatisUtil.getSqlSession();
			
			vo=sql.selectOne("member.getCommentVO",id);
			
			if(vo==null) {
				System.out.println("vo가 널");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sql.commit();
			sql.close();
		}
		
		return vo;
	}

	@Override
	public AttemptVO getAttemptVO(String id) {
		SqlSession sql = null;
		AttemptVO vo = null;
		try {
			sql=MybatisUtil.getSqlSession();
			
			vo=sql.selectOne("member.getAttemptVO",id);
			
			if(vo==null) {
				System.out.println("vo가 널");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sql.commit();
			sql.close();
		}
		
		return vo;
	}

	@Override
	public String getSysdateLog(String id) {
		SqlSession sql = null;
		String str = null;
		try {
			sql=MybatisUtil.getSqlSession();
			
			str=sql.selectOne("member.getSysdateLog",id);
			
			if(str==null) {
				System.out.println("str 널");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sql.commit();
			sql.close();
		}
		
		return str;
	}

	@Override
	public int getCountMate() {
		SqlSession sql = null;
		int cnt = 0;
		try {
			sql=MybatisUtil.getSqlSession();
			
			cnt=sql.selectOne("member.getCountMate");
			
			if(cnt==0) {
				System.out.println("getCountMate cnt 널");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sql.commit();
			sql.close();
		}
		
		return cnt;
	}

	@Override
	public int getCountViewList(String id) {
		SqlSession sql = null;
		int cnt = 0;
		try {
			sql=MybatisUtil.getSqlSession();
			
			cnt=sql.selectOne("member.getCountViewList",id);
			
			if(cnt==0) {
				System.out.println("getCountMate cnt 널");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sql.commit();
			sql.close();
		}
		  
		return cnt;
	}

	@Override
	public CustomerVO getCustomer(CustomerVO custVo) {
		CustomerVO cusvo=null;
		SqlSession session=null;
		
		try {
			session=MybatisUtil.getSqlSession();
			
			cusvo=session.selectOne("memberMypage.getCustomer", custVo);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.commit();
			session.close();
		}
		
		return cusvo;
	}

	@Override
	public int updateCustomer(CustomerVO custVo) {
		int cnt=0;
		SqlSession session=null;
		
		try {
			session=MybatisUtil.getSqlSession();
			cnt=session.update("memberMypage.updateCustomer", custVo);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.commit();
			session.close();
		}
		
		return cnt;
	}

	@Override
	public int deleteCustomer(String cusid) {
		int cnt=0;
		SqlSession session=null;
		try {
			session=MybatisUtil.getSqlSession();
			cnt=session.update("memberMypage.deleteCustomer", cusid);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.commit();
			session.close();
		}
		return cnt;
	}

	@Override
	public int newPassUpdate(CustomerVO cusVo) {
		int cnt=0;
		SqlSession session=null;
		System.out.println("dao A");
		try {
			session=MybatisUtil.getSqlSession();
			System.out.println("dao B");
			cnt=session.update("member.newPassUpdate", cusVo);
			System.out.println("dao C");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("dao D");
			session.commit();
			session.close();
		}
		return cnt;
	}


}
