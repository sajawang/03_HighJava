package kr.or.ddit.basic;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StackQueueTest {
	/*
	 * Stack ==> 후입선출(LIFO)의 자료 구조
	 * Queue ==> 선입선출(FIFO)의 자료 구조
	 * 
	 * Stack과 Queue는 LinkedList를 이용하여 사용할 수 있다.
	 */
	public static void main(String[] args) {
	/*
	 * Stack의 명령
	 * 1. 자료 입력 : push(입력값)
	 * 2. 자료 출력 : pop()  ==> 자료를 꺼내온 후 꺼내온 자료를 스택에서 삭제한다
	 * 			  peek() ==> 삭제없이 자료를 꺼내온다.
	 */
		Stack<String> stack = new Stack<String>();
		
		stack.push("홍길동");
		stack.push("일지매");
		stack.push("변학도");
		stack.push("강감찬");
		
		System.out.println("현재 Stack의 값들>> "+stack);
		System.out.println();
		
		String data = stack.pop();
		System.out.println("꺼내온 값>> " + data);
		System.out.println("꺼내온 값>> " + stack.pop()	);
		System.out.println("현재 Stack의 값들>> "+stack);
		System.out.println();
		
		stack.push("성춘향");
		System.out.println("추가 후 현재 stack의 값들 >> "+stack);
		System.out.println("꺼내온 값>> " + stack.pop()	);
		System.out.println("현재 Stack의 값들>> "+stack);
		System.out.println();

		System.out.println("삭제 없이 꺼내온 값>> "+stack.peek());
		System.out.println("현재 Stack의 값들>> "+stack);
		System.out.println();
		System.out.println("-----------------------------");
		System.out.println();
		
		/*
		 * Queue의 명령
		 * 1. 자료 입력 : offer(입력값)
		 * 2. 자료 출력 : poll() ==> 자료를 꺼내오고, 꺼내온 데이터를 Queue에서 삭제한다.
		 * 			  peek() ==> 삭제 없이 자료를 꺼내온다.
		 */
			Queue<String> queue = new LinkedList<String>();
			queue.offer("홍길동");
			queue.offer("일지매");
			queue.offer("변학도");
			queue.offer("강감찬");
			
			System.out.println("현재 queue의 값들 >> "+queue);
			
			String temp = queue.poll();
			System.out.println("꺼내온 값 >> "+temp);
			System.out.println("꺼내온 값 >> "+queue.poll());
			System.out.println("현재 queue의 값들 >> "+queue);
			System.out.println();
		
			queue.offer("성춘향");
			System.out.println("현재 queue의 값들 >> "+queue);
			System.out.println();
			
			System.out.println("꺼내온 값 >> "+queue.poll());
			System.out.println("현재 queue의 값들 >> "+queue);
			System.out.println();
			
			System.out.println("삭제 없이 꺼내오기 >> "+queue.peek());
			System.out.println("현재 queue의 값들 >> "+queue);
			
			
	}
}


































