package kr.or.ddit.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import kr.or.ddit.service.BoardServiceImpl;
import kr.or.ddit.service.IBoardService;
import kr.or.ddit.vo.BoardVO;

public class BoardController {
	private Scanner scan = new Scanner(System.in);
	private IBoardService service;
	
	public BoardController() {
		service = BoardServiceImpl.getInstance();
	}
	
	public static void main(String[] args) {
		new BoardController().testStart();
	}

	private void testStart() {
		while(true) {
			int choice = displayMenu();
			switch(choice) {
			case 1: //새글작성
				insert();
				break;
			case 2: //게시글보기
				list();
				break;
			case 3: //검색
				break;
			case 4: //수정
				break;
			case 5://삭제
				break;
			case 0: //작업끝
				System.out.println("작업 끝..");
				break;
			default:
				System.out.println("번호를 잘못입력했습니다");
				System.out.println("다시선택하세요");
			}
		}
	}

	private void list() {
		String no=null;
		System.out.println("보기를 원하는 게시물 번호 입력>>");
		no =scan.next();
		
		System.out.println(no+"번글 내용");
		System.out.println("------------------------------------------------------------");
		
		
		System.out.println("- 제  목 : 안녕하세요?      ");
		System.out.println("- 작성자 : 변학도           ");
		System.out.println("- 내  용 : 연습용 입니다.  ");
		System.out.println("- 작성일 : 2018-12-12");
		System.out.println("- 조회수 : 1");
		System.out.println("-------------------------------------------------------------");
		System.out.println("메뉴 : 1. 수정    2. 삭제    3. 리스트로 가기");
		System.out.println("작업선택 >> ");
		no =scan.next();
		
		
	    String title=null;	
	    String writer = null;
	    String content = null;
	    String date = null;
	    String cnt = null;
	    
	    //수정에 필요한 정보들을 Map에 추가한다.
	    //key값 ==> 회원 ID(MEMID), 수정할 컬럼명(FIELD), 수정할 데이터(DATA)
	    Map<String,String> paramMap = new HashMap<String,String>();
	    paramMap.put("MEMID",id);
	    paramMap.put("FIELD",updateField);
	    paramMap.put("DATA", updateData);
	    
	    int cnt = service.updateMember2(paramMap);
	    
	    if(cnt>0) {
	    	System.out.println("개별항목 수정작업 성공!!!");
	    } else {
	    	System.out.println("개별 항목 수정 작업 실패~~");
	    }
		
	}

	private void insert() {
		String title = null;
		String writer = null;
		String content = null;
		int cnt = 0;
		System.out.println("제목>>");
		title =scan.next();
		System.out.println("작성자>>");
		writer =scan.next();
		scan.nextLine();
		System.out.println("내용>>");
		content =scan.nextLine();
			
		BoardVO boardVo = new BoardVO();
		boardVo.setBoard_title(title);
		boardVo.setBoard_writer(writer);
		boardVo.setBoard_content(content);
		
		cnt = service.insertBoard(boardVo);
		
		if(cnt>0) {
			System.out.println("insert작업성공!!");
		} else {
			System.out.println("insert작업 실패");
		}
	}

	private int displayMenu() {
		displayAll();
		System.out.println("메뉴:1.새글작성\t2.게시글보기\t3.검색\t0.작업끝");
		System.out.println("작업선택>> ");
		
		return scan.nextInt();
	}
	
	private void displayAll() {
		System.out.println();
		
		List<BoardVO> boardList = service.getAllBoard();
		
		System.out.println("----------------------------");
		System.out.println(" No\t제 목\t작성자\t조회수");
		System.out.println("----------------------------");
		
		if(boardList==null || boardList.size()==0) {
			System.out.println("\t등록된 게시글이 하나도 없습니다.");
		} else {
			for(BoardVO bvo : boardList) {
				String no = bvo.getBoard_cnt();
				String title = bvo.getBoard_title();
				String writer = bvo.getBoard_writer();
				String cnt = bvo.getBoard_cnt();
				
				System.out.println(no+"\t"+title+"\t"+writer+"\t"+cnt);
			}
		}
		System.out.println("----------------------------");
	}
	
}





































