package kr.or.ddit.fileupload.service;

import java.util.List;

import kr.or.ddit.vo.FileinfoVO;

public interface IFileInfoService {
	//fileInfoVO에 저장된 자료를 DB에 insert하는 메서드
		//파라미터 : fileInfoVO insert할 자료가 저장된 FileInfoVO객체
		//리턴 : 작업성공 : 1, 작업실패 : 0
		public int insertFileInfo(FileinfoVO fileInfoVo);
		
		//DB에 저장된 전체 파일 목록을 가져와 List에 담아서 반환하는 메서드
		//리턴 : 파일목록이 저장된 메서드
		public List<FileinfoVO> getAllFileInfo();
		
		//파일번호를 매개변수로 받아서 해당 파일정보를 VO객체에 담아서 반환하는 메서드
		public FileinfoVO getFileInfo(int fileNo);
}
