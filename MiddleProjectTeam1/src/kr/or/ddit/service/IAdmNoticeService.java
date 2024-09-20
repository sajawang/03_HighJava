package kr.or.ddit.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.FileVO;
import kr.or.ddit.vo.PostVO;

public interface IAdmNoticeService {
		//공지사항
		//글리스트 가져오기<조회>
		public List<PostVO> selectNoticeList(int num);
		
		//글갯수구하기
		public int countNotice(Map<String, Object> map);
		
		//글쓰기<등록>
		public int insertNotice(PostVO vo);
		
		//글삭제<삭제>
		public int deleteNotice(PostVO pvo);
		
		//글수정<수정>
		public int updateNotice(PostVO vo);
		
		//postNo=boardNo
		public PostVO selectDetailNotice(Map<String, Object> map);

		//공지사항 파일 
		public List<FileVO> selectFile();
		
		//파일 넣기<등록>
		public int insertFile(FileVO vo);
}
