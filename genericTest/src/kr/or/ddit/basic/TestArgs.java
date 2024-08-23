package kr.or.ddit.basic;

public class TestArgs {

	//매개변수로 받은 정수들의 함계를 구하는 메서드를 작성하시오
	//(이 정수들의 개수는 상황에 따라 다를 수 있다.)
	public int sumArr(int[] data) {
		int sum=0;
		for (int x : data) {
			sum+=x;
		}
		return sum;
	}
	
	//가변인수 (가변인자) ==> 메서드를 호출할 때 인자의 개수가 다를 때 사용할 수 있다.
	// 		가변인자는 메서드  안에서는 배열로 처리된다.
	//		가변인자는 하나의 메서드에서 한 개만 사용할 수 있다.
	public int sumArg(int ...data) {
		int sum=0;
		for (int x : data) {
			sum+=x;
		}
		return sum;
	}
	
	// 가변인자와 일반적인 매개변수를 같이 사용하게 될 경우에는
	// 가변인자를 제일 뒤쪽에 배치해야 함
	public String sumArg2(String name, int ...data) {
		int sum=0;
		for (int x : data) {
			sum+=x;
		}
		return name+"의 합계 : "+sum;
		
	}
	
	public static void main(String[] args) {
		TestArgs test = new TestArgs();
		
		int[] nums = {100, 200, 300};
		System.out.println(test.sumArr(nums));
		System.out.println(test.sumArr(new int[] {1,2,3,4,5}));//1,2,3,4,5
		
		System.out.println(test.sumArg(100,200,300));
		System.out.println(test.sumArg(1,2,3,4,5));
		
		System.out.println(test.sumArg2("홍길동", 1,2,3,4,5,6,7,8,9));
	}

}
