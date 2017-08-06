package thread;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;




class Task1 implements Runnable{
	
	synchronized  public void IWannSay() throws Exception{
	
		System.out.println("start task1 ");
		wait();
	}
	

	@Override
	public void run() {
		while(!Thread.interrupted()){
			try {
				TimeUnit.MILLISECONDS.sleep(2000);
				IWannSay();
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}

class Task2 implements Runnable{

	
	
 synchronized 	public  void   getTask1(){
	  Task1 task1=new Task1();
	  notify();
 }
	
	@Override
	public void run() {
		while(!Thread.interrupted()){
			 getTask1();
				
			}
		}
		
	
	
}


public class Exc21 {
	
	public static void main(String[] args) throws Exception{
	ExecutorService es=Executors.newCachedThreadPool();
	es.execute(new Task1());
	es.execute(new Task2());
	
	TimeUnit.MILLISECONDS.sleep(200);
	es.shutdown();
	}

}
