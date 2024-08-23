package kr.or.ddit.basic;

import java.util.Stack;

public class StackTest {
	public static void main(String[] args) {
		Browser b = new Browser();
		
		b.history();
		
		b.goURL("1.네이버");
		b.history();
		
		b.goURL("2.야후");
		b.history();
		
		b.goURL("3.구글");
		b.history();
		
		b.goURL("4.다음");
		b.history();
		
		System.out.println("뒤로가기 후..");
		b.goBack();
		b.history();
		
		System.out.println("뒤로가기 후..");
		b.goBack();
		b.history();
		
		System.out.println("앞으로 가기 후...");
		b.goFoward();
		b.history();
		
		System.out.println("새로운 사이트 접속 후...");
		b.goURL("5.네이트");
		b.history();
	}
}

// 웹브라우저의 앞으로 가기, 뒤로 가기 기능 구현(스택 이용)
class Browser{
	private Stack<String> back;    //이전 방문 내역이 저장될 스택
	private Stack<String> forward; //다음 방문 내역이 저장될 스택
	private String currentURL;	   //현재 페이지
	
	//생성자
	public Browser() {
		back = new Stack<String>();
		forward = new Stack<String>();
		currentURL="";
	}
	
	//사이트를 방문하는 메서드 ==> 매개변수에는 방문할 URL이 저장되어 호출된다.
	public void goURL(String url) {
		System.out.println(url+"사이트에 접속합니다.");
		if(currentURL!=null&&!"".equals(currentURL)) {
			back.push(currentURL);
		}
		
		currentURL = url; //현재 페이지를 변경한다.
		forward.clear(); //새로운 사이트 접속하면 앞으로가기가 사라진다.
	}
	
	//뒤로가기
	public void goBack() {
		//isEmpty() ==> Collection이 비어 있으면 true를 반환한다.
		if(!back.isEmpty()) {
			forward.push(currentURL); //현재 페이지를 forward 스택에 추가한다.
			currentURL=back.pop();	  //back에서 1개의 요소를 꺼내와 현재 페이지로 한다.
		}
	}
	
	//앞으로 가기
	public void goFoward() {
		if(!forward.isEmpty()) {
			back.push(currentURL);   //현재 페이지를 back스택에 추가한다.
			currentURL=forward.pop();// forward에서 1개의 요소를 꺼내와 현재 페이지로 한다.
		}
	}
	
	//방문 기록 확인하기
	public void history() {
		System.out.println("-----------------------");
		System.out.println("        방문기록                      ");
		System.out.println("-----------------------");
		System.out.println("back ==> " +back);
		System.out.println("현재 ==>"+currentURL);
		System.out.println("forard ==> "+forward);
		System.out.println("-----------------------");
		System.out.println();
	}
}
