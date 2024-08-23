package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
 * 문제) 학번, 이름, 국어점수, 영어점수, 수학점수, 총점, 등수를 멤버로 갖는 Student클래스를 만든다.
	이 클래스의 생성자에서는 학번, 이름, 국어점수, 영어점수, 수학점수만 매개변수로 받아서
	초기화 처리를 한다. (이 때 총점은 세 과목 점수를 이용해서 초기화 한다.)

	이 Student객체는 List에 저장하여 관리한다.

	List에 저장된 데이터들을 학번의 오름차순으로 정렬할 수 있는 내부 정렬 기준을 구현하고,
	총점의 역순(내림차순)으로 정렬 하는데 총점이 같으면 이름의 오름차순으로 정렬이 되는
	
	
	외부 정렬 기준 클래스를 작성하여 정렬된 결과를 출력하시오.
	(외부 정렬 클래스명 : SortByTotal)

	(단, 등수는 List에 전체 데이터가 추가된 후에 저장되도록 한다.)
 */

			//제목을 StudentTest로 했으면 Student 클래스 쓸 수 있다.
public class Student {
	
	//등수 구하는 메소드
	//매개변수에 리스트를 받아와야 함
	public void createRank(ArrayList<Students> studentList) {
		for (Students std1 : studentList) {//기준 데이터를 구하기 위한 반복문
			int best =1;	//처음에는 1등으로 설정해 놓고 시작한다.
			
			for(Students std2 : studentList) {
				if(std1.getTotal() < std2.getTotal()) {
					best++;
				}
			}
			
			std1.setBest(best); //최종적으로 구해진 등수를 Student객체의 rank변수에 저장한다.
		}
	}
	
	public static void main(String[] args) {
		ArrayList<Students> studentList = new ArrayList<Students>();
		
		Student stu = new Student();
		stu.createRank(studentList);
		
		studentList.add(new Students(4,"이자바", 10,60,5));
		studentList.add(new Students(2,"감자바", 30,80,20));
		studentList.add(new Students(5,"구자바", 5,50,1));
		studentList.add(new Students(3,"오자바", 20,70,40));
		studentList.add(new Students(1,"김자바", 50,90,30));
		
		
		System.out.println("정렬전 >>");
		for (Students students : studentList) {
			System.out.println(students);
		}
		System.out.println("----------------------");
		
		
		//내부정렬 기준으로 정렬(학번의 오름차순)
		Collections.sort(studentList);
		
		System.out.println("학번 기준으로 오름차순>>"); 
		for (Students students : studentList) {
			System.out.println(students);
		}
		System.out.println("----------------------");
		
		
		//외부정렬 기준으로 정렬
		Collections.sort(studentList, new SortByTotal());
		
		System.out.println("총점기준 내림차순, 이름기준 오름차순>>");
		for (Students students : studentList) {
			System.out.println(students);
		}
		System.out.println("----------------------");
		
		
	}
}

class Students implements Comparable<Students>{
	private int num;
	private String name;
	private int korS;
	private int engS;
	private int mathS;
	private int total;
	private int best;
	
	public Students() {
		
	}
	
	//생성자
	public Students(int num, String name, int korS, int engS, int mathS) {
		super();
		this.num = num;
		this.name = name;
		this.korS = korS;
		this.engS = engS;
		this.mathS = mathS;
		//this 안써도 됨
		this.total = korS+engS+mathS;
		
	}
	
	
	
	
	//게터세터
	public int getBest() {
		return best;
	}

	public void setBest(int num) {
		this.num = best;
	}
	
	
	
	public int getTotal() {
		return total;
	}
	public void setTotal(int num) {
		this.num = total;
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



	public int getKorS() {
		return korS;
	}



	public void setKorS(int korS) {
		this.korS = korS;
	}



	public int getEngS() {
		return engS;
	}



	public void setEngS(int engS) {
		this.engS = engS;
	}



	public int getMathS() {
		return mathS;
	}



	public void setMathS(int mathS) {
		this.mathS = mathS;
	}

	
	//출력용
	@Override
	public String toString() {
		return "Students [num=" + num + ", name=" + name + ", korS=" + korS + ", engS=" + engS + ", mathS=" + mathS
				+ ", total=" + total + ", best=" + best + "]";
	}


	//학번의 오름차순으로 정렬
	@Override
	public int compareTo(Students o) {
		return new Integer(getNum()).compareTo(o.getNum());
	} 
}

//총점의 역순(내림차순)으로 정렬 하는데 총점이 같으면 이름의 오름차순으로 정렬이 되는
//외부 정렬 기준 클래스를 작성하여 정렬된 결과를 출력하시오.
//(외부 정렬 클래스명 : SortByTotal)

class SortByTotal implements Comparator<Students>{ //SortByTotal에 빨간줄이 뜨면
													//마우스 올려서 unimplemet어쩌구 선택하면됨

	@Override
	public int compare(Students o1, Students o2) {
		//교수님 풀이
		if(o1.getTotal()==o2.getTotal()) {
			return o1.getName().compareTo(o2.getName());
		} else {
			return Integer.compare(o1.getTotal(), o2.getTotal())*-1;
		}
		
		/*if(o1.getTotal()>o2.getTotal()) {
			return -1;
		} else if(o1.getTotal()==o2.getTotal()) {
			
			return o1.getName().compareTo(o2.getName());
		} else {
			return 1;
		}*/
		
		/*return new Integer(o1.getTotal()).compareTo(o2.getTotal())*-1;*/
	}

	
	
}
	
