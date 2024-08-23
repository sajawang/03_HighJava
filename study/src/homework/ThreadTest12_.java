package homework;

public class ThreadTest12_ {
	public static void main(String[] args) {
		Horses[] th = new Horses[] {
				new Horses("말이름01"),
				new Horses("말이름02"),
				new Horses("말이름03"),
				new Horses("말이름04"),
				new Horses("말이름05"),
				new Horses("말이름06"),
				new Horses("말이름07"),
				new Horses("말이름08"),
				new Horses("말이름09"),
				new Horses("말이름10"),
		};
		
		for (Horses horses : th) {
			try {
				horses.start();
				Thread.sleep(100);
			} catch (InterruptedException e) {}
		}
		
		for(int i=0; i<th.length; i++) {
			try{th[i].join();}
			catch(InterruptedException e) {}
		}
		System.out.println();
		System.out.println("--결과--");
		System.out.println(Horses.result);
	}
}

class Horses extends Thread{
	private String name;
	public static int rank;
	private int location;
	public static String result="";
	
	public Horses(String name) {
		super();
		this.name = name;
	}
	
	@Override
	public void run() {
		while(location<=50) {
			location += (int)(Math.random()*4);
			System.out.println(name+" ");
			
			for(int i=0; i<location; i++) {System.out.print("-");}
			
			System.out.print(">");
			
			for(int i=0; i<50-location; i++) {System.out.print("-");}
			
			System.out.println();
			
			try {Thread.sleep(300);} 
			catch (InterruptedException e) {}
		}			
		rank++;
		result += name+" : "+rank+"등\n";
	}
}