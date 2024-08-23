package kr.or.ddit.basic;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class TeacherPhoneBookTest {
	
	private HashMap<String, Phone> phonebookMap;
	private Scanner sc;
	
	//생성자
	public TeacherPhoneBookTest() {
		phonebookMap = new HashMap<String, Phone>();
		sc = new Scanner(System.in);
	}
	
	
	public static void main(String[] args) {
		new TeacherPhoneBookTest().phoneStart();
	}

	//시작 메서드
	private void phoneStart() {
		System.out.println();
		System.out.println("**********************************");
		System.out.println("           전화번호 관리 프로그램                      ");
		System.out.println("**********************************");
		System.out.println();
		
		while (true) {
			int choice = displayMenu();
			switch (choice) {
			case 1://등록
				insert();
				break;
			case 2://수정
				update();
				break;
			case 3://삭제
				delete();
				break;
			case 4://검색
				search();
				break;
			case 5: //전체 출력
				displayAll();
				break;
			case 0: //종료
				System.out.println();
				System.out.println("프로그램을 종료합니다");
				return;

			default:
				System.out.println();
				System.out.println("작업번호를 잘못입력헀습니다");
				System.out.println("다시 선택하세요");
			}
		}
	}
	
	//전홥너호 정보를 검색하는 메서드
	private void search() {
		System.out.println();
		System.out.println("검색할 전화번호 정보를 입력하세요");
		System.out.println("이름 >> ");
		String name = sc.next();
		
		Phone p = phonebookMap.get(name);
		
		if(p==null) {
			System.out.println(name+"의 정보가 없습니다.");
		} else {
			System.out.println(name+"의 전화번호");
			System.out.println("--------------");
			System.out.println("이름 " + p.getName());
			System.out.println("전화 " + p.getTel());
			System.out.println("주소 " + p.getAdd());
		}
		
	}


	//전화번호 정보를 삭제하는 메서드
	private void delete() {
		System.out.println();
		System.out.println("삭제할 전화번호 정보를 입력하세요");
		System.out.println("이름 >>");
		String name = sc.next();
		
		//존재 여부 검사
		if(!phonebookMap.containsKey(name)) {
			System.out.println(name+"는 등록되지 않은 사람입니다");
			return;
		}
		
		phonebookMap.remove(name);
		
		System.out.println(name+"의 정보를 삭제했습니다.");
		
	}


	private void update() {
		System.out.println();
		System.out.println("수정할 전화번호 정보 입력");
		
		System.out.println("이름 >>");
		String name = sc.next();
		
		//해당 이름이 없으면 수정 작업을 못한다.
		if(!phonebookMap.containsKey(name)) {
			System.out.println(name+"의 전화번호 없다.");
			System.out.println("수정작업을 마칩니다.");
			return;
		}
		
		System.out.println("새로운 전화번호 >>");
		String newTel = sc.next();
		
		System.out.println("새로운 주소>> ");
		String newaddr = sc.next();
		
		//같은 key값에 새로운 전화번호 정보를 저장 ==> 수정
		phonebookMap.put(name, new Phone(name, newTel, newaddr));
		
		System.out.println(name+"의 전화번호 정보를 변경함");
		
	}


	//전체 전화번호 정보를 출력하는 메서드
	private void displayAll() {
		System.out.println();
		System.out.println("----------------------------");
		System.out.println("번호           이름               전화번호               주소");
		System.out.println("----------------------------");
		
		Set<String> phoneKeySet = phonebookMap.keySet();
		if(phoneKeySet.size()==0) {
			System.out.println("등록된 전화번호 정보가 하나도 없습니다.");
		} else {
			int count =0; //번호 출력용
			for (String key : phoneKeySet) {
				count++;
				Phone p = phonebookMap.get(key); //value값 구하기
				
				System.out.println(count+"\t"+p.getName()+"\t"+p.getTel()+"\t"+p.getAdd());
				
			}
		}
		System.out.println("--------------------------");
	}


	// 전화번호 정보를 등록하는 메서드
	private void insert() {
		System.out.println();
		System.out.println("새롭게 등록할 전화번호 정보를 입력하세요.");
		
		System.out.println("이름>>");
		String name = sc.next();
		
		// 이미 등록된 사람인지 검사하기(key값에 해당 이름이 있는지 검사)
		if(phonebookMap.containsKey(name)) {
			System.out.println(name+"는 이미 등록된 사람입니다");
			return;
		}
		
		System.out.println("전화번호>> ");
		String tel = sc.next();
		
		System.out.println("주소>> "	);
		String addr = sc.next();
		
		//입력 받은 자료를 이용하여 Phone 객체 생성
		Phone p = new Phone(name, tel, addr);
		//Map에 추가하기
		phonebookMap.put(name, p);
		
		//위의 두줄을 한줄로 줄이는법
		//phonebookMap.put(name, new Phone(name,tel,addr));
		
		System.out.println(name+"의 정보를 등록하였습니다.");
		
	}


	//메뉴를 출력하고 작업 번호를 입력 받아 반환하는 메서드
	private int displayMenu() {
		System.out.println("------------------------");
		System.out.println("1. 전화번호 등록");
		System.out.println("2. 전화번호 수정");
		System.out.println("3. 전화번호 삭제");
		System.out.println("4. 전화번호 검색");
		System.out.println("5. 전화번호 전체 출력");
		System.out.println("0. 프로그램 종료");
		System.out.println("------------------------");
		System.out.print("번호 입력 >> ");
		return sc.nextInt();
	}
}

//이름, 주소, 전화번호를 멤버로 갖는 Phone 클래스
class Phone1{
	private String name;
	private String tel;
	private String addr;
	
	//생성자
	public Phone1(String name, String tel, String addr) {
		super();
		this.name = name;
		this.tel = tel;
		this.addr = addr;
	}
	
	
	//getter, setter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	@Override
	public String toString() {
		return "Phone [name=" + name + ", tel=" + tel + ", addr=" + addr + "]";
	}
	
}