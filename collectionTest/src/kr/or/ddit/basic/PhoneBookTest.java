package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

/*
 * 문제) 이름, 주소, 전화번호를 멤버로 갖는 Phone클래스를 만들고,
 * 		Map을 이용하여 전화번호 정보를 관리하는 프로그램을 작성하시오.
 *		
 *		(Map의 구조==> key값으로는 '이름'을 사용하고, 
 *					value값으로는 'phone객체의 인스턴스'를 사용한다.)
 *		HashMap<String, Phone> 변수; 
 * 
 * 		아래의 실행 예시의 메뉴를 모두 구현히시오.
 * 실행예시)
 * 		======================
 * 		1.전화번호 등록
 * 		2.전화번호 수정
 * 		3. 전화번호  삭제
 * 		4. 전화번호 겁색
 * 		5. 전화번호 전체 출력
 *		6.프로그램 종료
 *------------------
 *번호입력 >>
 *
 *새롭게 등록할 전화번호 정보를 입력하세요...
 *이름>> 홍길동
 *전화번호>>010-5555-1111
 *
 *예외처리) '홍길동'은 이미 등록된 사랍입니다.
 *			
 */
public class PhoneBookTest {
	Scanner sc = new Scanner(System.in);
	
	private HashMap<String, Phone> phonebookMap=new HashMap<String, Phone>();
	private List<HashMap<String,Phone>> list = new ArrayList();
	
	
	public static void main(String[] args) {
		PhoneBookTest obj = new PhoneBookTest();
		obj.process();
	}
	
	HashSet<String> setName = new HashSet<String>();

	private void process() {
		while (true) {
			System.out.println("------------------------");
			System.out.println("1. 전화번호 등록");
			System.out.println("2. 전화번호 수정");
			System.out.println("3. 전화번호 삭제");
			System.out.println("4. 전화번호 검색");
			System.out.println("5. 전화번호 전체 출력");
			System.out.println("0. 프로그램 종료");
			System.out.println("------------------------");
			System.out.print("번호 입력 >> ");
			int sel = sc.nextInt();
			
			switch (sel) {
			case 1:
				System.out.println("새롭게 등록할 전화번호 정보를 입력하세요");
				System.out.println("이름 >> ");
				String name = sc.next();
				
				if(!setName.add(name)) {
					System.out.println(name+"는 이미 등록된 사람입니다.");
					break;
				}
				System.out.println("전화번호>>");
				String tel = sc.nextLine();
				System.out.println("주소>> ");
				String add = sc.next();
				
				Phone phone = new Phone(name,tel,add);
				
				phonebookMap.put(name,phone);
				list.add(phonebookMap);
				phone.setNum(list.size());
				
				System.out.println(name+"의 전화번호 등록 완료");
				break;

			default:
				break;
			}
		}
		
	}
}

class Phone{
	private int num;
	private String name;
	private String tel;
	private String add;
	
	//생성자 단축키 alt+shift+s
	public Phone(String name, String tel, String add) {
		super();
		this.name = name;
		this.tel = tel;
		this.add = add;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

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

	public String getAdd() {
		return add;
	}

	public void setAdd(String add) {
		this.add = add;
	}
	
	
	
	
}
