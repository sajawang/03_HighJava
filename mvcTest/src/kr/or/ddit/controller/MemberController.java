package kr.or.ddit.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import kr.or.ddit.service.IMemberService;
import kr.or.ddit.service.MemberServiceImpl;
import kr.or.ddit.vo.MemberVO;

public class MemberController {
	private Scanner scan = new Scanner(System.in);
	private IMemberService service; //Service객체가 저장될 변수 선언
	
	//생성자
	public MemberController() {
		service = MemberServiceImpl.getInstance();
	}


	public static void main(String[] args) {
		new MemberController().testStart();
	}

	
	private int displayMenu() {
		
	return 0;
	}
	
	private void testStart() {
		while(true) {
			int choice = displayMenu();
			switch(choice) {
			case 1: //추가
				insert();
				break;
			case 2: //삭제
				delete();
				break;
			case 3: //전체 항목 수정
				update();
				break;
			case 4: //전체자료 출력
				displayAll();
				break;
			case 5://자료수정2 ==>원하는 항목 1개만 수정
				update2();
				break;
			case 0: //종룔
				System.out.println("작업 끝..");
				break;
			default:
				System.out.println("번호를 잘못입력했습니다");
				System.out.println("다시선택하세요");
			}
		}
	}

	//updqt메서드==>원하는 항목만 수정
	private void update2() {
		System.out.println("수정할 아이디를 입력>>");
	    String id = scan.next();
	    
	    int count = service.getMemberIdCount(id);
	    
	    if(count==0) {
	    	//없는 회원이면
	    	System.out.println(id+"는 없는 회원id입니다");
	    	System.out.println("수정작업을 마칩니다...");
	    	return;
	    }
	    
	    int num; //선택한 항목 번호가 저장될 변수
	    String updateField=null;	//변경할 컬러명이 저장될 변수
	    String titleMsg = null;	//변경할 값을 입력 받을 때 나타나는 메시지가 저장될 변수
	    
	    do {
			System.out.println();
			System.out.println("수정할 항목을 선택하세요");
			System.out.println("1.비밀번호 2.회원이름 3.전화번호 4.회원주소");
			System.out.println("---------------------");
			System.out.println("수정할 항목 선택>> ");
			num = scan.nextInt();
			
			switch (num) {
			case 1: updateField="mem_pass"; titleMsg="비밀번호"; break;
			case 2: updateField="mem_name"; titleMsg="회원이름"; break;
			case 3: updateField="mem_tel"; titleMsg="전화번호"; break;
			case 4: updateField="mem_addr"; titleMsg="회원주소"; break;
			default: System.out.println("수정할 항목 선택이 잘못되었습니다. 다시 선택하세요.");
			}
		} while (num<1 || num>4 );
	    
	    System.out.println();
	    System.out.println("새로운"+titleMsg+"입력>> ");
	    scan.nextLine();//입력버퍼 비우기
	    String updateData = scan.nextLine();
	    
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


	//전체회원목록출력
	private void displayAll() {
		System.out.println();
		
		List<MemberVO> memList = service.getAllMember();
		
		System.out.println();
		System.out.println("\t===검색결과===");
		System.out.println("아이디\t비밀번호\t이름\t전화번호\t주소");
		System.out.println("-----------------------------");
		
		if(memList==null || memList.size()==0) {
			System.out.println("\t등록된 회원이 하나도 없습니다.");
		} else {
			for(MemberVO mvo : memList) {
				String id = mvo.getMem_id();
				String pa = mvo.getMem_pass();
				String name = mvo.getMem_name();
				String tel = mvo.getMem_tel();
				String addr = mvo.getMem_addr();
				
				System.out.println(id+"\t"+pa+"\t"+name+"\t"+tel+"\t"+addr);
			}
		}
		System.out.println("----------------------------");
	}


	//전체 항목 수정
	private void update() {
		System.out.println("수정할 아이디를 입력>>");
	    String id = scan.next();
	    
	    int count = service.getMemberIdCount(id);
	    
	    if(count==0) {
	    	//없는 회원이면
	    	System.out.println(id+"는 없는 회원id입니다");
	    	System.out.println("수정작업을 마칩니다...");
	    	return;
	    }
	    
	    System.out.println("패스워드>>");
	    String pa = scan.next();

	    System.out.println("이름>> ");
	    String name = scan.next();
	    
	    System.out.println("전화번호>>");
	    String tel = scan.next();
	    
	    scan.nextLine();//입력 버퍼 비우긱
	    System.out.println("주소>>");
	    String addr = scan.nextLine();
	    
	    //입력 밥ㄷ은 자료를 VO객체에 저장한다.
	    MemberVO memVo = new MemberVO();
	    memVo.setMem_id(id);
	    memVo.setMem_pass(pa);
	    memVo.setMem_name(name);
	    memVo.setMem_tel(tel);
	    memVo.setMem_addr(addr);
	    
	    int cnt = service.updateMember(memVo);
	    
	    if(cnt>0) {
	    	System.out.println("수정작업성공");
	    } else {
	    	System.out.println("수정작업실패");
	    }
	}


	private void delete() {
		System.out.println("삭제할 아이디를 입력>>");
		String id = scan.next();

		int cnt=service.deleteMember(id);
		
		if(cnt>0) {
			System.out.println("삭제작업 성공!!");
		} else {
			System.out.println("삭제 작업 실패!!");
		}
	}


	//insert메서드
	private void insert() {
		String id = null;
		int count = 0;
		do {
			System.out.println("아이디>>");
			id =scan.next();
			
			count = service.getMemberIdCount(id);
			
			if(count>0) {
				System.out.println(id+"는 이미 등록된 아이디 입니다.");
			}
		} while (count>0);
		
	
		System.out.println("패스워드>>");
		String pa = scan.next();

		System.out.println("이름>> ");
		String name = scan.next();
		
		System.out.println("전화번호>>");
		String tel = scan.next();
		
		scan.nextLine();//입력버퍼 비워주는 역할, nextLine은 앞을 검사한다고 함
		System.out.println("주소>>");
		//주소에는 띄워쓰기가 많기 때문에
		String addr = scan.nextLine();
		
		//입력 받은 데이터들을 MemberVO객체에 저장한다.
		MemberVO memVo = new MemberVO();
		memVo.setMem_id(id);
		memVo.setMem_pass(pa);
		memVo.setMem_name(name);
		memVo.setMem_tel(tel);
		memVo.setMem_addr(addr);
		
		//Service의 insert하는 메서드를 호출한다.
		//이때 insert할 데이터가 저장된  MemverVO객체를 인수값으로 보내준다.
		int cnt = service.insertMember(memVo);
		
		if(cnt>0) {
			System.out.println("insert작업성공!!");
		} else {
			System.out.println("insert작업 실패");
		}
	}
	
}






























































