package kr.or.ddit.fileupload.service;

import java.util.List;

import kr.or.ddit.fileupload.dao.FileInfoDaoImpl;
import kr.or.ddit.fileupload.dao.IFileInfoDao;
import kr.or.ddit.vo.FileinfoVO;

public class FileInfoServiceImpl implements IFileInfoService {
	private IFileInfoDao dao;
	private FileInfoServiceImpl(){
		dao=FileInfoDaoImpl.getInstance();
	}
	
	
	private static FileInfoServiceImpl service;
	public static FileInfoServiceImpl getService() {
		if(service==null) service = new FileInfoServiceImpl();
		return service;
	}
	
	
	@Override
	public int insertFileInfo(FileinfoVO fileInfoVo) {
		// TODO Auto-generated method stub
		return dao.insertFileInfo(fileInfoVo);
	}

	@Override
	public List<FileinfoVO> getAllFileInfo() {
		// TODO Auto-generated method stub
		return dao.getAllFileInfo();
	}

	@Override
	public FileinfoVO getFileInfo(int fileNo) {
		// TODO Auto-generated method stub
		return dao.getFileInfo(fileNo);
	}

}
