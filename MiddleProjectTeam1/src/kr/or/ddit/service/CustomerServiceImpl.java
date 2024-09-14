package kr.or.ddit.service;

import kr.or.ddit.dao.ICustomerDao;
import kr.or.ddit.dao.CustomerDaoImpl;
import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.CustomerVO;

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
