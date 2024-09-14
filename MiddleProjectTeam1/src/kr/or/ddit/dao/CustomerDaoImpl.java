package kr.or.ddit.dao;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.util.MybatisUtil;
import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.CustomerVO;

public class CustomerDaoImpl implements ICustomerDao {

	private static CustomerDaoImpl dao;
	
	private CustomerDaoImpl() {}
	
	public static CustomerDaoImpl getInstance() {
		if(dao==null)dao=new CustomerDaoImpl();
		return (CustomerDaoImpl) dao;
	}
	

	@Override
	public String idCheck(String id) {
		String userId = null;
		SqlSession session=null;
		int cnt = 0;
		
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
		int cnt = 0;
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
	public int insertMember(MemberVO memVo) {
		String userId = null;
		SqlSession session=null;
		int cnt = 0;
		
		try {
			session=MybatisUtil.getSqlSession();
			
			userId=session.selectOne("member.idCheck", memVo);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.commit();
			session.close();
		}
		
		
		return cnt;
	}

	@Override
	public int login(CustomerVO userVo) {
		SqlSession session = null;
		int cnt = 0;
		
		try {
			
			session = MybatisUtil.getSqlSession();
			
			cnt=session.insert("member.inmember",userVo);
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			session.commit();
			session.close();
		}
		
		return cnt;
	}

	
	
	
	
	
	
	
	//0912 추가
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

	//0913 추가
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

}
