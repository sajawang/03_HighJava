package kr.or.ddit.service;

import kr.or.ddit.dao.IMathSettingDao;
import kr.or.ddit.dao.IMemberDao;
import kr.or.ddit.dao.MathSettingDaoImpl;
import kr.or.ddit.dao.MemberDaoImpl;
import kr.or.ddit.vo.MathSettingVO;
import kr.or.ddit.vo.QuestionVO;

public class MathSettingServiceImpl implements IMathSettingService {
	private IMathSettingDao dao;	
	private MathSettingServiceImpl() {
		dao = MathSettingDaoImpl.getInstance(); 
	}
	private static MathSettingServiceImpl service;
	public static MathSettingServiceImpl getInstance() {
		if(service==null) service = new MathSettingServiceImpl();
		return service;
	}
	@Override
	public int insertMathSet(MathSettingVO mathVo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateQueSet(MathSettingVO mathVo, QuestionVO queVo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int selfUpdateMath(MathSettingVO mathVo) {
		// TODO Auto-generated method stub
		return dao.selfUpdateMath(mathVo);
	}

	@Override
	public int deleteMathSet(int mathNo) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public String getSysdateLog(String id) {
	      // TODO Auto-generated method stub
	      return dao.getSysdateLog(id);
	   }
	@Override
	public MathSettingVO getMathSetting(String cusid) {
		// TODO Auto-generated method stub
		return dao.getMathSetting(cusid);
	}

}
