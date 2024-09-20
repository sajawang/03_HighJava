package kr.or.ddit.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.dao.ITeacherLibraryDao;
import kr.or.ddit.dao.TeacherLibraryDaoImpl;
import kr.or.ddit.vo.PageVO;
import kr.or.ddit.vo.PostVO;

public class TeacherLibraryServiceImpl implements ITeacherLibraryService {
	private static TeacherLibraryServiceImpl service;
	private ITeacherLibraryDao dao;
	
	private TeacherLibraryServiceImpl() {
		dao = TeacherLibraryDaoImpl.getInstance(); 
	}
	
	public static TeacherLibraryServiceImpl getInstance() {
		if(service == null) service = new TeacherLibraryServiceImpl();
		return service;
	}
	
	
	@Override
	public PostVO detailTeacherLib(int postNo) {
		return dao.detailTeacherLib(postNo);
	}

	@Override
	public int insertTeacherLib(PostVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateTeacherLib(PostVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteTeacherLib(int postNo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateHitTeacherLib(int postNo) {
		return dao.updateHitTeacherLib(postNo);
	}

	@Override
	public List<PostVO> getAllTeacherLib(Map<String, Object> map) {
		return dao.getAllTeacherLib(map);
	}

	@Override
	public int countTeacherLib(Map<String, Object> map) {
		return dao.countTeacherLib(map);
	}
	
	@Override
	public PageVO pageInfo(int page, String school, String grade) {
		PageVO pvo = new PageVO();
		
		// 전체 글 갯수 가져오기 
		// map 설정
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("school", school);
		map.put("grade", grade);
		
		// 전체 글 갯수 가져오기
		int count = this.countTeacherLib(map);
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

}
