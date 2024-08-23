package kr.or.ddit.basic;

import java.io.Serializable;

//직렬화 ==> 메모리 상의 객체를 저장 또는 전송하기 위해서 다른 형태로 변환하는 작업

//직렬화가 가능하게 하려면 Serializable인터페이스를 구현해야 한다.
public class Member implements Serializable{
	//멤버 중에 z직렬화 대상에서 빼고 싶은 멤버에 transient를 지정
	private String name;
	private transient int age;
	private transient String addr;
	
	public Member(String name, int age, String addr) {
		super();
		this.name = name;
		this.age = age;
		this.addr = addr;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	
}
