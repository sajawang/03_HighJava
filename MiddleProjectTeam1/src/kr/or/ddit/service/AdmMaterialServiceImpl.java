package kr.or.ddit.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.dao.AdmMaterialDaoImpl;
import kr.or.ddit.dao.CSPostDaoImpl;
import kr.or.ddit.dao.IAdmMaterialDao;
import kr.or.ddit.dao.ICSPostDao;
import kr.or.ddit.vo.MaterialVO;
import kr.or.ddit.vo.QuestionVO;

public class AdmMaterialServiceImpl implements IAdmMaterialService {
	
	private IAdmMaterialDao dao;
	private static AdmMaterialServiceImpl service;
	
	private AdmMaterialServiceImpl() {
		System.out.println("gg");
		dao = AdmMaterialDaoImpl.getInstance();
	}
	public static AdmMaterialServiceImpl getInstance() {
		if(service==null)service= new AdmMaterialServiceImpl();
		System.out.println("dd");
		return service;
	}
	
	
	@Override
	public MaterialVO detailMaterial(int material_no) {
		
		return dao.detailMaterial(material_no);
	}

	@Override
	public int insertMaterial(MaterialVO vo) {
		
		return dao.insertMaterial(vo);
	}

	@Override
	public int updateMaterial(MaterialVO vo) {
		
		return dao.updateMaterial(vo);
	}

	@Override
	public int deleteMaterial(int material_no) {
		
		return dao.deleteMaterial(material_no);
	}

	@Override
	public List<MaterialVO> selectAllMaterial() {
		
		return dao.selectAllMaterial();
	}

	@Override
	public int countMaterial(Map<String, Object> map) {
		
		return 0;
	}
	@Override
	public int adminInsertMateFile(String fileName) {
		
		return dao.adminInsertMateFile(fileName);
	}
	@Override
	public int adminInsertMate(MaterialVO mateVo) {
		
		return dao.adminInsertMate(mateVo);
	}
	@Override
	public Integer adminSelectMateFileNum(String fileName) {
		// TODO Auto-generated method stub
		return dao.adminSelectMateFileNum(fileName);
	}
	@Override
	public List<QuestionVO> getQuestionList() {
		// TODO Auto-generated method stub
		return dao.getQuestionList();
	}
	@Override
	public List<QuestionVO> getMateQuestionList(int mateNo) {
		// TODO Auto-generated method stub
		return dao.getMateQuestionList(mateNo);
	}
<<<<<<< .mine
	@Override
	public String adminSelectMateFileName(int fileNo) {
		// TODO Auto-generated method stub
		return null;
	}
||||||| .r443686
=======
	@Override
	public String adminSelectMateFileName(int fileNo) {
		// TODO Auto-generated method stub
		return dao.adminSelectMateFileName(fileNo);
	}
	@Override
	public QuestionVO selectDetailQuestion(int queNo) {
		// TODO Auto-generated method stub
		return dao.selectDetailQuestion(queNo);
	}
	@Override
	public int adminSelectMateQueNum(String queFileName) {
		// TODO Auto-generated method stub
		return dao.adminSelectMateQueNum(queFileName);
	}
	@Override
	public String adminSelectMateQueName(int queFileNo) {
		// TODO Auto-generated method stub
		return dao.adminSelectMateQueName(queFileNo);
	}
>>>>>>> .r444302
	

}
