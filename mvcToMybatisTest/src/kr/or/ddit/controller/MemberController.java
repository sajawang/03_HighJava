package kr.or.ddit.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import kr.or.ddit.service.IMemberService;
import kr.or.ddit.service.MemberServiceImpl;
import kr.or.ddit.vo.MemberVO;

public class MemberController {
	private IMemberService service;  // Service객체가 저장될 변수 선언
	private Scanner scan;
	
	// 생성자
	public MemberController() {
		scan = new Scanner(System.in);
//		service = new MemberServiceImpl();
		service = MemberServiceImpl.getInstance();
	}

	public static void main(String[] args) {
		new MemberController().startMember();
	}

	// 시작 메서드
	public void startMember() {
		while(true) {
			int choice = displayMenu();
			switch(choice) {
				case 1 :			// 자료 추가
					insertMember(); break;
				case 2 :			// 자료 삭제
					deleteMember();	break;
				case 3 :			// 자료 수정 ==> 전체 항목 수정
					updateMember();	break;
				case 4 :			// 전체 출력
					displayAllMember();	break;
				case 5 :			// 자료 수정2 ==> 원하는 항목 1개만 수정
					updateMember2(); break;
				case 0 :	// 작업 끝...
					System.out.println("작업을 마칩니다...");
					return;
				default :
					System.out.println("작업 번호를 잘못 입력 했습니다.");
					System.out.println("다시 입력하세요...");
			}
		}
	}
	
	// update 메서드 ==> 원하는 항목만 수정
	private void updateMember2() {
		System.out.println();
		System.out.println("수정할 회원 정보를 입력하세요...");
		System.out.print("수정할 회원ID 입력 >> ");
		String memId = scan.next();
		
		int count = service.getMemberIdCount(memId);
		
		if(count==0) {   // 없는 회원이면...
			System.out.println(memId + "는(은) 없는 회원ID 입니다...");
			System.out.println("수정 작업을 마칩니다...");
			return;
		}
		
		
		int num;	// 선택한 항목 번호가 저장될 변수
		String updateField = null;		// 변경할 컬럼명이 저장될 변수
		String titleMsg = null;			// 변경할 값을 입력 받을 때 나타나는 메시지가 저장될 변수
		
		do {
			System.out.println();
			System.out.println("수정할 항목을 선택하세요...");
			System.out.println("1.비밀번호  2.회원이름  3.전화번호  4.회원주소");
			System.out.println("-----------------------------------");
			System.out.print("수정할 항목 선택 >> ");
			num = scan.nextInt();
			
			switch(num) {
				case 1 : updateField = "mem_pass"; titleMsg = "비밀번호"; break;
				case 2 : updateField = "mem_name"; titleMsg = "회원이름";	break;
				case 3 : updateField = "mem_tel"; titleMsg = "전화번호"; 	break;
				case 4 : updateField = "mem_addr"; titleMsg = "회원주소";	break;
				default : System.out.println("수정할 항목 선택이 잘못되었습니다. 다시 선택하세요...");
			}
		}while(num<1 || num>4);
		
		scan.nextLine(); // 입력 버퍼 비우기
		System.out.println();
		System.out.print("새로운 " + titleMsg + " 입력 >> ");
		String updateData = scan.nextLine();
		
		// 수정에 필요한 정보들을 Map에 추가한다.
		//  key값 ==> 회원ID(MEMID), 수정할 컬럼명(FIELD), 수정할 데이터(DATA)
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("MEMID", memId);
		paramMap.put("FIELD", updateField);
		paramMap.put("DATA", updateData);
		
		int cnt = service.updateMember2(paramMap);
		
		if(cnt>0) {
			System.out.println("개별 항목 수정 작업 성공!!!");
		}else {
			System.out.println("개별 항목 수정 작업 실패~~~");
		}
		
	}
	
	
	// 전체 회원 목록 출력
	private void displayAllMember() {
		System.out.println();
		
		List<MemberVO> memList = service.getAllMember();
		
		System.out.println("-----------------------------------------------");
		System.out.println(" ID\t 비밀번호\t 회원이름\t 전화번호\t 회원주소");
		System.out.println("-----------------------------------------------");
		
		if(memList==null || memList.size()==0) {
			System.out.println("\t등록된 회원이 하나도 없습니다...");
		}else {
			for(MemberVO mvo : memList) {
				String id = mvo.getMem_id();
				String pass = mvo.getMem_pass();
				String name = mvo.getMem_name();
				String tel = mvo.getMem_tel();
				String addr = mvo.getMem_addr();
				
				System.out.println(id + "\t" + pass + "\t" + name + "\t" + tel + "\t" + addr);
			}
		}
		
		System.out.println("-----------------------------------------------");
	}
	
	
	// update 메서드 ==> 전체 항목 수정
	private void updateMember() {
		System.out.println();
		System.out.println("수정할 회원 정보를 입력하세요...");
		System.out.print("수정할 회원ID 입력 >> ");
		String memId = scan.next();
		
		int count = service.getMemberIdCount(memId);
		
		if(count==0) {   // 없는 회원이면...
			System.out.println(memId + "는(은) 없는 회원ID 입니다...");
			System.out.println("수정 작업을 마칩니다...");
			return;
		}
		
		System.out.println("수정할 내용을 입력하세요...");
		System.out.print("새로운 비밀번호 입력 >> ");
		String newMemPass = scan.next();
		
		System.out.print("새로운 회원이름 입력 >> ");
		String newMemName = scan.next();
		
		System.out.print("새로운 전화번호 입력 >> ");
		String newMemTel = scan.next();
		
		scan.nextLine();  // 입력 버퍼 비우기
		System.out.print("새로운 회원주소 입력 >> ");
		String newMemAddr = scan.nextLine();
		
		// 입력 받은 자료를 VO객체에 저장한다.
		MemberVO memVo = new MemberVO();
		memVo.setMem_id(memId);
		memVo.setMem_pass(newMemPass);
		memVo.setMem_name(newMemName);
		memVo.setMem_tel(newMemTel);
		memVo.setMem_addr(newMemAddr);
		
		int cnt = service.updateMember(memVo);
		
		if(cnt>0) {
			System.out.println("전체 항목 수정 작업 성공!!!");
		}else {
			System.out.println("전체 항목 수정 작업 실패~~~");
		}
		
		
	}
	
	
	// delete 메서드
	private void deleteMember() {
		System.out.println();
		System.out.println("삭제할 회원 정보를 입력하세요...");
		System.out.print("삭제할 회원ID 입력 >> ");
		String memId = scan.next();
		
		int cnt = service.deleteMember(memId);
		
		if(cnt>0) {
			System.out.println("삭제 작업 성공!!!");
		}else {
			System.out.println("삭제 작업 실패~~~");
		}
		
	}
	
	
	
	// insert메서드
	private void insertMember() {
		System.out.println();
		System.out.println("추가할 회원 정보를 입력하세요...");
		
		String memId = null;		// 회원ID가 저장될 변수
		int count = 0;
		do {
			
			System.out.print("회원ID 입력 >> ");
			memId = scan.next();
			
			count = service.getMemberIdCount(memId);
			
			if(count>0) {
				System.out.println(memId + "는(은) 이미 등록된 회원ID 입니다. ");
				System.out.println("다른 회원ID를 입력하세요...");
				System.out.println();
			}
			
		}while(count>0);
		
		System.out.print("비밀번호 입력 >> ");
		String memPass = scan.next();
		
		System.out.print("회원이름 입력 >> ");
		String memName = scan.next();
		
		System.out.print("전화번호 입력 >> ");
		String memTel = scan.next();
		
		scan.nextLine();   // 입력 버퍼 비우기
		System.out.print("회원주소 입력 >> ");
		String memAddr = scan.nextLine();
		
		// 입력 받은 데이터들을 MemberVO객체에 저장한다.
		MemberVO memVo = new MemberVO();
		memVo.setMem_id(memId);
		memVo.setMem_pass(memPass);
		memVo.setMem_name(memName);
		memVo.setMem_tel(memTel);
		memVo.setMem_addr(memAddr);
		
		// Service의 insert하는 메서드를 호출한다.
		// 이 때 insert할 데이터가 저장된 MemverVO객체를 인수값으로 보내준다.
		int cnt = service.insertMember(memVo);
		
		if(cnt>0) {
			System.out.println("insert 작업 성공!!!");
		}else {
			System.out.println("insert 작업 실패~~~");
		}
		
	}
	
	
	
	// 메뉴를 출력하고 작업 번호를 입력 받아 반환하는 메서드
	private int displayMenu() {
		System.out.println();
		System.out.println(" == 작업 선택 ==");
		System.out.println("1. 자료 추가");
		System.out.println("2. 자료 삭제");
		System.out.println("3. 자료 수정");
		System.out.println("4. 전체 자료 출력");
		System.out.println("5. 자료 수정2");
		System.out.println("0. 작업 끝...");
		System.out.println("================");
		System.out.print("작업 선택 >> ");
		return scan.nextInt();
	}
	
}
