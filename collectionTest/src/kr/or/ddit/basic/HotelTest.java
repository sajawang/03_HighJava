package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class HotelTest {
	
	private Map<Integer, Room> hotelMap;
	private Scanner scan;
	
	//역할 : hotelMap초기화
	public HotelTest() {
		hotelMap = new HashMap<Integer, Room>();
		scan = new Scanner(System.in);
		
		//hotelMap.put(201, new Room(201, "싱글")); -> 없어보이니까 반복문 사용하세영 ㅋㅋ
		
		//객실 초기화
		for (int i = 2; i < 4; i++) {
			String roomType = null;	//방 종류가 저장될 변수 선언
			switch(i) {
				case 2 : roomType = "싱글룸"; break;
				case 3 : roomType = "더블룸"; break;
				case 4 : roomType = "스위트룸"; break;
			}
			for (int j = 1; j <= 9; j++) {
				int roomNumber = i * 100 + j;
				
				Room room = new Room(roomNumber, roomType);
				hotelMap.put(roomNumber, room);
			}
		}
		
		
	}
	public static void main(String[] args) {
		new HotelTest().hotelStart();
	}
	
	//시작 메서드
	public void hotelStart() {
		System.out.println("********************************************* ");
		System.out.println("       호텔문을 열었습니다. 어서오십시요. ");
		System.out.println("********************************************* ");
		System.out.println();
		
		while (true) {
			int choice = displayMenu();
			
			switch (choice) {
			case 1: //체크인
				checkin();
				break;
			case 2: //체크아웃
				checkout();
				break;
			case 3: //객실상태
				displayAllRoom();
				break;
			case 4: //종료
				System.out.println();
				System.out.println("********************************************* ");
				System.out.println("                    호텔문을 닫았습니다.               ");
				System.out.println("********************************************* ");
				return;
			default:
				System.out.println("번호를 잘못눌렀습니다.");
				System.out.println("다시선택하세요.");
			}
		}
		
	}
	
	private void checkout() {
		System.out.println();
		System.out.println("----------------------------------------------");
		System.out.println("   체크아웃 작업");
		System.out.println("----------------------------------------------");
		System.out.println("체크아웃 할 방 번호를 입력하세요.");
		System.out.println(" 방번호 입력 >>");                  
		int roomNum=scan.nextInt();
		
		//방번호가 없는지 검사
		if(!hotelMap.containsKey(roomNum)) {
			System.out.println(roomNum+"호 객실은 존재하지 않습니다");
			return;
		}
		
		//해당 객실의 손님 이름을 구해온다.
		String guestName = hotelMap.get(roomNum).getGuestName();
		
		//해당 객실에 손님이 없는지 검사
		if(guestName==null) {
			System.out.println(roomNum+"호 객실에는 체크인 한 사람이 없습니다.");
			return;
		}
		
		//체크 아웃 처리 ==> 해당 객실의 투숙객 이름을 null로 변경
		hotelMap.get(roomNum).setGuestName(null);
		
		System.out.println(roomNum+"호 객실의 "+guestName+"님이 체크아웃 처리를 완료했습니다.");
		
		
	}
	//객실상태를 출력하는 메서드
	private void displayAllRoom() {
		System.out.println();
		System.out.println("----------------------------------------------");
		System.out.println("		현재 객실 상태");
		System.out.println("----------------------------------------------");
		System.out.println("방 번호	 방 종류	 투숙객 이름");
		System.out.println("----------------------------------------------");
		
		//방번호를 순서대로 처리하기 위해 방번호(key값)만 List에 넣어서 정렬하여 사용
		Set<Integer> roomNumSet = hotelMap.keySet();
		List<Integer> roomList = new ArrayList<Integer>(roomNumSet);
		Collections.sort(roomList);
		
		for (Integer roomNum : roomList) {
			Room r = hotelMap.get(roomNum);
			System.out.print(r.getNum()+"\t");
			System.out.print(r.getType()+"\t");
			System.out.println(r.getGuestName() == null ? "-" : r.getGuestName());
		}
		
		System.out.println("----------------------------");
	}
	//체크인 하는 메서드
	private void checkin() {
		System.out.println("----------------------------------------------");
		System.out.println("   체크인 작업");
		System.out.println("----------------------------------------------");
		System.out.println(" * 201~209 : 싱글룸");
		System.out.println(" * 301~309 : 더블룸");
		System.out.println(" * 401~409 : 스위트룸");
		System.out.println("----------------------------------------------");
		System.out.println("방 번호 입력 >> ");
		
		int num=scan.nextInt();
		
		//입력한 방번호가 없는지 확인
		if (!hotelMap.containsKey(num)) {
			System.out.println(num+"호 객실은 존재하지 않습니다.");
			return;
		}
		
		// 해당 객실에 다른 투숙객이 있는지 검사
		if (hotelMap.get(num).getGuestName()!=null) {
			System.out.println(num+"호 객실에는 이미 손님이 있습니다.");
			return;
		}
		
		System.out.println("누구를 체크인 하시겠습니까?");
		System.out.println("이름 입력 >> ");
		String name= scan.next();
		
		//입력 받은 이름을 해당 객실의 투숙객 이름에 저장한다.
		hotelMap.get(num).setGuestName(name);
		
		System.out.println(num+"호 객실에 "+name+"님의 체크인이 완료되었습니다.");
	}
	
	//메뉴를 출력하고 작업 번호를 입력 받아 반환하는 메서드
	private int displayMenu() {
		System.out.println("-----------------------------------------------------------");
		System.out.println("어떤 업무를 하시겠습니까?");
		System.out.println("1. 체크인    2. 체크아웃    3. 객실상태    4. 업무종료");
		System.out.println("-----------------------------------------------------------");
		System.out.print("선택>> ");
		return scan.nextInt();
	}
}


class Room{
	private int num;
	private String type;
	private String guestName;
	
	//기본생성자(매개변수가 없는 생성자를 기본생성자라고 한다)
	public Room() {
		
	}

	//매개변수가 있는 생성자
	public Room(int num, String type) {
		super();
		this.num = num;
		this.type = type;
	}

	//getter, setter
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getGuestName() {
		return guestName;
	}

	public void setGuestName(String guestName) {
		this.guestName = guestName;
	}
}