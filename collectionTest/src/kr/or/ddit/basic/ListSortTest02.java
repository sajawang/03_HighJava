package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ListSortTest02 {
	public static void main(String[] args) {
		ArrayList<Member> memList = new ArrayList<Member>();
		
		memList.add(new Member(1, "홍길동", "010-1111-1111"));
		memList.add(new Member(5, "이순신", "010-1111-1111"));
		memList.add(new Member(9, "성춘향", "010-1111-1111"));
		memList.add(new Member(3, "강감찬", "010-1111-1111"));
		memList.add(new Member(6, "일지매", "010-1111-1111"));
		memList.add(new Member(2, "변학도", "010-1111-1111"));
		
		System.out.println("정렬전...");
		for (Member member : memList) {
			System.out.println(member);
		}
		System.out.println("------------------------");
		
		Collections.sort(memList); //memList의 내부정렬기준을 가지고 
		//정렬을 하려고 하는데 -> 못해서 빨간줄 뜨는것(sort)
		
		System.out.println("이름의 오름차순 정렬 후...");
		for (Member member : memList) {
			System.out.println(member);
		}
		System.out.println("------------------------");

		Collections.sort(memList, new SortNumDesc());
		System.out.println("번호의 내림차순 정렬 후...");
		for (Member member : memList) {
			System.out.println(member);
		}
		System.out.println("------------------------");
		
	}
}

//Member클래스의 회원 이름을 기준으로 오름차순이 되도록 내부 정렬 기준 추가하기
// ==> Comparable 인터페이스를 구현한다.
class Member implements Comparable<Member>{
	private int num;
	private String name;
	private String tel;
	//단축키 alt+shift+s
	//생성자 만드는 단축키 
	//generate constructor,getter setter, toString 모두 가능
	
	//생성자
	public Member(int num, String name, String tel) {
		super();
		this.num = num;
		this.name = name;
		this.tel = tel;
	}
	
	//게터 세터
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
	
	//toString
	@Override
	public String toString() {
		return "Member [num=" + num + ", name=" + name + ", tel=" + tel + "]";
	}

	//회원 이름을 기준으로 오름차순
	@Override
	public int compareTo(Member mem) {
		/*
		if(this.getName().compareTo(mem.getName())>0) {
			return 1;
		} else if(this.getName().compareTo(mem.getName())<0) {
			return -1;
		} else {
			return 0;
		}
		*/
		return this.getName().compareTo(mem.getName());
	
	}
}

//Member의 회원번호(변수 num)의 내림차순으로 정렬하는 외부 정렬 기준 클래스를 작성하시오
//클래스명 : SortNumDesc

class SortNumDesc implements Comparator<Member>{
	@Override
	public int compare(Member o1, Member o2) {
		//if(o1.getNum()>o2.getNum()){
		//	 return -1;(안바꾸려면 음수 반환)
		//else if(o1.getNum() < o2.getNum()){
		//	 return 1;
		//else 
		//	 return 0;
		
		//Wrapper 클래스를 이용하는 방법
		//return new Integer(o1.getNum()).compareTo(o2.getNum())*-1;
		
		//Wrapper 클래스를 이용하는 방법2
		return Integer.compare(o1.getNum(), o2.getNum())*-1;
	}
}