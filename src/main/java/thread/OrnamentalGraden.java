package thread;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static net.mindview.util.Print.*;

class Count{
	private int count=0;
	private Random r=new Random(47);
	synchronized public int  increment(){
		int tep=count;
		if(r.nextBoolean()){
			Thread.yield();
		}
	 return (	count=++tep);
	}
	
	synchronized public int getValue(){
		return count;
	}
}

class Enterance implements Runnable{
	 static private Count count=new Count();
	
	synchronized public int getValue(){
		return number;
	}
	
	public static  void canceled(){
		cancel=true;
	}
	private static  volatile  boolean cancel=false; 
	private  final int id;
	private int number=0;
	private CountDownLatch latch;
	public Enterance(int id ,CountDownLatch latch) {
		this.id=id;
		this.latch=latch;
		
	}
	
	
	
	public String toString(){
		return ("Enterance"+id+":"+number);
	}
	
	@Override
	public void run() {
		while(!cancel){
			synchronized (this) {
				++number;
			}
	
			print(this+" Total "+count.increment());
			
			latch.countDown();
			
	
		}
/*		try {
			latch.await();
	
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
*/
		print("stop"+this); 
		
	}
	 
}


public class OrnamentalGraden {
	static final int SIZE=100;
	public static void main(String[] args) throws InterruptedException{
		ExecutorService executorService=Executors.newCachedThreadPool();
		CountDownLatch latch=new CountDownLatch(SIZE);
		Count count=new Count();
		for(int i=0;i<5;i++)
			executorService.execute(new Enterance(i, latch));
		TimeUnit.SECONDS.sleep(3);
		Enterance.canceled();
		executorService.shutdown();
		
		
		
	}
}
