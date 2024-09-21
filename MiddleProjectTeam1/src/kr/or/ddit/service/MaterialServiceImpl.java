package kr.or.ddit.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.dao.IMaterialDao;
import kr.or.ddit.dao.MaterialDaoImpl;
import kr.or.ddit.vo.AttemptVO;
import kr.or.ddit.vo.MaterialVO;
import kr.or.ddit.vo.PageVO;
import kr.or.ddit.vo.ViewListVO;
import kr.or.ddit.vo.MathSettingVO;
import kr.or.ddit.vo.MemberVO;

public class MaterialServiceImpl implements IMaterialService{
	private static MaterialServiceImpl service;
	private IMaterialDao dao;
	
	private MaterialServiceImpl() {
		dao = MaterialDaoImpl.getInstance(); 
	}
	
	public static MaterialServiceImpl getInstance() {
		if(service == null) service = new MaterialServiceImpl();
		
		return service;
	}

	@Override
	public int InsertMaterial(MaterialVO mateVo) {
		return dao.InsertMaterial(mateVo);
	}

	@Override
	public List<MaterialVO> selectMaterial(Map<String, Object> map) {
		return dao.selectMaterial(map);
	}

	@Override
	public MaterialVO selectDetailMaterial(int mateNo) {
		return dao.selectDetailMaterial(mateNo);
	}

	@Override
	public int UpdateMaterial(MaterialVO mateVo) {
		return dao.UpdateMaterial(mateVo);
	}

	@Override
	public int DeleteMaterial(int mateNo) {
		return dao.DeleteMaterial(mateNo);
	}

	@Override
	public List<MaterialVO> getMaterQuestionFile(int mateNo) {
		return dao.getMaterQuestionFile(mateNo);
	}

	@Override
	public int insertViewList(Map<String, Object> map) {
		return dao.insertViewList(map);
	}

	@Override
	public int insertAttempt(AttemptVO vo) {
		return dao.insertAttempt(vo);
	}

	@Override
	public int countMaterial(Map<String, Object> map) {
		return dao.countMaterial(map);
	}

	@Override
	public PageVO pageInfo(int page, String school, String grade, String cate, String level) {
		PageVO pvo = new PageVO();
		
		// 전체 글 갯수 가져오기 
		// map 설정
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("school", school);
		map.put("grade", grade);
		map.put("cate", cate);
		map.put("level", level);
		
		// 전체 글 갯수 가져오기
		int count = this.countMaterial(map);
		System.out.print("count : ");
		System.out.println(count);
		
		// 전체 페이지 수 구하기
		int perList = pvo.getPerList();
		int totalPage = (int) Math.ceil(count / (double)perList);
		
		// 마지막 페이지에서 마지막 데이터를 지웠을 때
		// page변수는 7(마지막페이지) - totalPage = 6으로 바뀜
		if(page > totalPage) {
			page = totalPage;
		}
		
		// start, end
		int start = (page-1) * perList + 1;
		int end = start + perList - 1;
		
		if(count < end) end = count;
		
		// startPage, endPage 1 2 / 3 4 / 5 6 / 7 8 /
		int perPage = PageVO.getPerPage();
		int startPage = ((page-1) / perPage * perPage) +1;
		int endPage = startPage + perPage - 1;
		if( endPage > totalPage) endPage = totalPage;
		
		pvo.setStart(start);
		pvo.setEnd(end);
		pvo.setStartPage(startPage);
		pvo.setEndPage(endPage);
		pvo.setTotalPage(totalPage);
		System.out.print("pvo : ");
		System.out.println(pvo.toString());
		
		return pvo;
	}

	@Override
	public List<MaterialVO> firstMaterial(Map<String, Object> map) {
		return dao.firstMaterial(map);
	}
	@Override
	public List<ViewListVO> getViewMaterial(String cusid) {
		// TODO Auto-generated method stub
		return dao.getViewMaterial(cusid);
	}
	@Override
	public List<ViewListVO> getMyMaterial(String cusid) {
		// TODO Auto-generated method stub
		return dao.getMyMaterial(cusid);
	}

	@Override
	public MaterialVO todayTenMinMaterial(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return dao.todayTenMinMaterial(map);
	}
	@Override
	public int updateMemberPoint(MemberVO mvo) {
		return dao.updateMemberPoint(mvo);
	}

	@Override
	public MathSettingVO getMathMinute(String cusId) {
		return dao.getMathMinute(cusId);
	}

	@Override
	public List<ViewListVO> getMyAnswer(ViewListVO vo) {
		return dao.getMyAnswer(vo);
	}
}	
	
