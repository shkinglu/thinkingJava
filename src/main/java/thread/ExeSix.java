package thread;

import java.util.Random;

public class ExeSix implements Runnable {

	private int seed;
	
	
	Random r=new Random(31);
	
	public ExeSix() {
		
	}
	
	public ExeSix(int seed) {
		this.seed=seed;
	}
	
	@Override
	public void run() {
	try {
		
		Thread.sleep(r.nextInt(10));
		System.out.println("sleetp"+r.nextInt(10)+"seconds");
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}
	
	public static void main(String args[]){
		for(int i=0;i<5;i++){
			new Thread(new ExeSix(i)).start();
		}
		
	}
}
