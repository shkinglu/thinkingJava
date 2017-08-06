package thread;

public class Exe_21_2_2_1 implements Runnable {

	 public Exe_21_2_2_1() {
		System.out.print("begin start");
		
		
	}
	
	@Override
	public void run() {
		for(int i=0;i<3;i++){
		System.out.println("Bai");
		Thread.yield();
		}
	}
	
	
	
}
