package kr.or.ddit.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.FileVO;
import kr.or.ddit.vo.PostVO;

public interface IAdminTeacherLibraryDao {

	 //글리스트 가져오기<조회>
	public List<PostVO> selectLibraryList(int num);
	
	//글 갯수구하기
	public int countLibrary (Map<String, Object> map);
	
	//글쓰기<등록>
	public int insertLibrary(PostVO vo);
	
	//글삭제<삭제>
	public int deleteLibrary(PostVO pvo);
	
	//글수정<수정>
	public int updateLibrary(PostVO vo);
	
	//postNo=boardNo
	public PostVO selectDetailLibrary(Map<String, Object> map);

	//선생님 자료실 파일
	public List<FileVO> selectFile();

	//파일 넣기<등록>
	public int insertFile(FileVO vo);
	
	//파일이름 조인에서 가지고와
	public PostVO getPostWithFile(int num);
//페이징처리 필요
public List<PostVO> getAllAdminTeacherLib(Map<String, Object> map);//검색,페이징처리도
public int countAdminTeacherLiv(Map<String, Object> map);
}
