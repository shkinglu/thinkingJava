package thread;

import java.util.concurrent.TimeUnit;

public class SimpleDaemons implements Runnable {
	
	
	

	public static void main(String[] args) throws Exception {
		for(int i=0;i<10;i++){
			Thread dem=new Thread(new SimpleDaemons());
			dem.setDaemon(true);
			dem.start();
		}
		System.out.println("all start");
		TimeUnit.MILLISECONDS.sleep(200);
	}

	@Override
	public void run() {
		try {
			while(true){
				TimeUnit.MILLISECONDS.sleep(100);
				System.out.println( Thread.currentThread()+" "+this);
			}
		} catch (Exception e) {
			System.out.println("sleep interrupted");
		}
		
	}

}
