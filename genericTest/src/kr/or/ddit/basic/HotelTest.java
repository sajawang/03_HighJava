package kr.or.ddit.basic;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class HotelTest {
	public Scanner sc = new Scanner(System.in);
	public HashMap<Integer, Room> roomMap = new HashMap<Integer, Room>();
	
	//생성자
	public HotelTest() {
		roomMap = new HashMap<Integer, Room>();
		sc = new Scanner(System.in);
		
		for (int i = 201; i < 210; i++) {
			roomMap.put(i, new Room(i,"싱글룸","-"));
		}
		for (int i = 301; i < 310; i++) {
			roomMap.put(i, new Room(i,"더블룸","-"));
		}
		for (int i = 401; i < 410; i++) {
			roomMap.put(i, new Room(i,"스위트룸","-"));
		}
		
		Set<Integer> roomKeySet = roomMap.keySet();
		for (Integer integer : roomKeySet) {
			Room r = roomMap.get(integer);
		}
	}
	
	public static void main(String[] args) {
		new HotelTest().hotelStart();
	}
	
	private void roominitial() {
		for (int i = 201; i < 210; i++) {
			roomMap.put(i, new Room(i,"싱글룸","-"));
		}
		for (int i = 301; i < 310; i++) {
			roomMap.put(i, new Room(i,"더블룸","-"));
		}
		for (int i = 401; i < 410; i++) {
			roomMap.put(i, new Room(i,"스위트룸","-"));
		}
		
		
		System.out.println("방번호"+"\t"+"방종류"+"\t"+"투숙객이름");
		System.out.println("-----------------------------------");
		Set<Integer> roomKeySet = roomMap.keySet();
		for (Integer integer : roomKeySet) {
			Room r = roomMap.get(integer);
			System.out.println(r.getRoomnum()+"\t"+r.getroomtype()+"\t"+r.getName());
		}
		System.out.println("-----------------------------------");
		
	}
	
	private void hotelStart() {
		System.out.println("********************************************* ");
		System.out.println("       호텔문을 열었습니다. 어서오십시요. ");
		System.out.println("********************************************* ");
		
		while (true) {
			int choice = displaymenu();
			switch (choice) {
			case 1:
				checkin();
				break;
			case 2:
				checkout();
				break;
			case 3:
				roomcondition();
				break;
			case 4:
				System.out.println();
				System.out.println("업무를 종료합니다.");
				return;
			default:
				System.out.println("번호를 잘못눌렀습니다.");
				System.out.println("다시선택하세요.");
			}
		}
	}

	private void checkout() {
		System.out.println("----------------------------------------------");
		System.out.println("   체크아웃 작업");
		System.out.println("----------------------------------------------");
		System.out.println("체크아웃 할 방 번호를 입력하세요.");
		System.out.println(" 방번호 입력 >>");                  
		int roomnum=sc.nextInt();
		
		Room r = roomMap.get(roomnum);
		
		if(r.getName().equals("-")==true) {
			System.out.println(roomnum+"호 에는 체크인 한 사람이 없습니다.");
		} else {
			System.out.println(roomnum+"호 객실의 "+r.getName()+"님 체크아웃을 완료하였습니다.");
			r.setName("-");
		}
	}

	private void roomcondition() {
		System.out.println("방번호"+"\t"+"방종류"+"\t"+"투숙객이름");
		System.out.println("-----------------------------------");
		Set<Integer> roomKeySet = roomMap.keySet();
		for (Integer integer : roomKeySet) {
			Room r = roomMap.get(integer);
			System.out.println(r.getRoomnum()+"\t"+r.getroomtype()+"\t"+r.getName());
		}
		System.out.println("-----------------------------------");
		
		
		System.out.println();
		
	}

	private void checkin() {
		System.out.println("----------------------------------------------");
		System.out.println("   체크인 작업");
		System.out.println("----------------------------------------------");
		System.out.println(" * 201~209 : 싱글룸");
		System.out.println(" * 301~309 : 더블룸");
		System.out.println(" * 401~409 : 스위트룸");
		System.out.println("----------------------------------------------");
		System.out.println("방 번호 입력 >> ");
		int roomnum=sc.nextInt();
		
		Room r = roomMap.get(roomnum);
		
		
		if(!roomMap.containsKey(roomnum)) {
			System.out.println(roomnum+"호 객실은 존재하지 않습니다.");	
		} else if(r.getName() != "-") {
			System.out.println(roomnum+"호 객실은 이미 손님이 있습니다.");
		} else {
			System.out.println("누구를 체크인 하시겠습니까?");
			System.out.println("이름 입력 >> ");
			String name= sc.next();
			r.setName(name);
			
			System.out.println("체크인이 완료되었습니다.");
		}
		
	}

	private int displaymenu() {
		System.out.println("-----------------------------------------------------------");
		System.out.println("어떤 업무를 하시겠습니까?");
		System.out.println("1. 체크인    2. 체크아웃    3. 객실상태    4. 업무종료");
		System.out.println("-----------------------------------------------------------");
		System.out.print("선택>> ");
		return sc.nextInt();
	}
}

class Room{
	int roomnum;
	String roomtype;
	String name;
	
	
	public Room(String roomtype, String name) {
		super();
		this.roomtype = roomtype;
		this.name = name;
	}
	
	
	public Room(int roomnum, String roomtype, String name) {
		super();
		this.roomnum = roomnum;
		this.roomtype = roomtype;
		this.name = name;
	}
	
	
	public int getRoomnum() {
		return roomnum;
	}
	public void setRoomnum(int roomnum) {
		this.roomnum = roomnum;
	}
	public String getroomtype() {
		return roomtype;
	}
	public void setroomtype(String roomtype) {
		this.roomtype = roomtype;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Room [roomnum=" + roomnum + ", roomtype=" + roomtype + ", name=" + name + "]";
	}
	
	
	
}





















