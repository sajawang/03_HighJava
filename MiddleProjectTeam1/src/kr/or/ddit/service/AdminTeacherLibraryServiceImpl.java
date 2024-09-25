package kr.or.ddit.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.dao.AdminTeacherLibraryDaoImpl;
import kr.or.ddit.dao.IAdminTeacherLibraryDao;
import kr.or.ddit.vo.FileVO;
import kr.or.ddit.vo.PostVO;

public class AdminTeacherLibraryServiceImpl implements IAdminTeacherLibraryService {

	private IAdminTeacherLibraryDao dao;

	private static AdminTeacherLibraryServiceImpl service;

	private AdminTeacherLibraryServiceImpl() {
		dao = AdminTeacherLibraryDaoImpl.getInstance();
	}

	public static AdminTeacherLibraryServiceImpl getInstance() {
		if (service == null)
			service = new AdminTeacherLibraryServiceImpl();
		return service;

	}

	@Override
	public List<PostVO> selectLibraryList(int num) {
		// TODO Auto-generated method stub
		return dao.selectLibraryList(num);
	}

	@Override
	public int countLibrary(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return dao.countLibrary(map);
	}

	@Override
	public int insertLibrary(PostVO vo) {
		// TODO Auto-generated method stub
		return dao.insertLibrary(vo);
	}

	@Override
	public int deleteLibrary(PostVO pvo) {
		// TODO Auto-generated method stub
		return dao.deleteLibrary(pvo);
	}

	@Override
	public int updateLibrary(PostVO vo) {
		// TODO Auto-generated method stub
		return dao.updateLibrary(vo);
	}

	@Override
	public PostVO selectDetailLibrary(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return dao.selectDetailLibrary(map);
	}

	@Override
	public List<FileVO> selectFile() {
		// TODO Auto-generated method stub
		return dao.selectFile();
	}

	@Override
	public int insertFile(FileVO vo) {
		// TODO Auto-generated method stub
		return dao.insertFile(vo);
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
		// TODO Auto-generated method stub
		return dao.getPostWithFile(num);
	}

}
