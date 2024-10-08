package kr.or.ddit.service;

import kr.or.ddit.dao.ICustomerDao;
import kr.or.ddit.dao.CustomerDaoImpl;
import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.PostVO;
import kr.or.ddit.vo.ViewListVO;
import kr.or.ddit.vo.AttemptVO;
import kr.or.ddit.vo.CommentVO;
import kr.or.ddit.vo.CustomerVO;
import kr.or.ddit.vo.FavoriteVO;
import kr.or.ddit.vo.MathSettingVO;

public class CustomerServiceImpl implements ICustomerService {
	private ICustomerDao dao;
	
	private static CustomerServiceImpl service;
	
	private CustomerServiceImpl() {
		dao=CustomerDaoImpl.getInstance();
	}
	public static CustomerServiceImpl getInstance() {
		if(service==null)service=new CustomerServiceImpl();
		return service;
	}
	@Override
	public String idCheck(String id) {
		
		return dao.idCheck(id);
	}

	
	@Override
	public String idFind(MemberVO memVo) {
		
		return dao.idFind(memVo);
	}

	@Override
	public int insertMember(MemberVO memVo) {
		
		return dao.insertMember(memVo);
	}
	@Override
	public int Login(CustomerVO userVo) {
		
		return dao.login(userVo);
	}
	
	@Override
	public int insertCustomer(CustomerVO cusVo) {
		
		return dao.insertCustomer(cusVo);
	}
	@Override
	public CustomerVO getLoginUser(CustomerVO cusVo) {
		
		return dao.getLoginUser(cusVo);
	}
	@Override
	public int newPassIdCheck(MemberVO memVo) {
		
		return dao.newPassIdCheck(memVo);
	}
	@Override
	public int newPassUpdate(CustomerVO cusVo) {
		
		return dao.newPassUpdate(cusVo);
	}
	@Override
	public MemberVO getLoginMemberPoint(MemberVO memVo) {
		
		return dao.getLoginMemberPoint(memVo);
	}
	@Override
	public FavoriteVO getFavoriteVO(String id) {
		
		return dao.getFavoriteVO(id);
	}
	@Override
	public ViewListVO getViewListVO(String id) {
		
		return dao.getViewListVO(id);
	}
	@Override
	public PostVO getPostVO(String id) {
		
		return dao.getPostVO(id);
	}
	@Override
	public MathSettingVO getMathSettingVO(String id) {
		
		return dao.getMathSettingVO(id);
	}
	@Override
	public CommentVO getCommentVO(String id) {
		
		return dao.getCommentVO(id);
	}
	@Override
	public AttemptVO getAttemptVO(String id) {
		
		return dao.getAttemptVO(id);
	}
	@Override
	public String getSysdateLog(String id) {
		// TODO Auto-generated method stub
		return dao.getSysdateLog(id);
	}
	@Override
	public int getCountMate() {
		// TODO Auto-generated method stub
		return dao.getCountMate();
	}
	@Override
	public int getCountViewList(String id) {
		// TODO Auto-generated method stub
		return dao.getCountViewList(id);
	}
	@Override
	public CustomerVO getCustomer(CustomerVO custVo) {
		// TODO Auto-generated method stub
		return dao.getCustomer(custVo);
	}
	@Override
	public int updateCustomer(CustomerVO custVo) {
		// TODO Auto-generated method stub
		return dao.updateCustomer(custVo);
	}
	@Override
	public int deleteCustomer(String cusid) {
		// TODO Auto-generated method stub
		return dao.deleteCustomer(cusid);
	}
	


}
