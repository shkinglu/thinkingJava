package thread;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import net.mindview.util.Print;

public class RadiusCount {
 private int count=0;
 
 public synchronized int  increment(){
	  int temp=count;
	  Thread.yield();
	  count=++temp;
	  return count;
 }
 
 public synchronized int value(){
	 return count;
 }
 
 
}
class transducer implements Runnable{
	private static RadiusCount count=new RadiusCount();
	private static ArrayList<transducer>  transducer=new ArrayList<transducer>();
	
	private int number=0;
	private final int id;
	
	private volatile static boolean canceled= false;
	
	public transducer(int id){
		this.id=id;
		transducer.add(this);
	}
	
	public static void cancel(){
		canceled=true;
	}

	@Override
	public void run() {
		while(!canceled){
			synchronized (this) {
				++number;
			}
			Print.print(this+"Total : "+count.increment());
			try {
				TimeUnit.MILLISECONDS.sleep(100);
			} catch (InterruptedException e) {
				Print.print("sleep interrupted");
			}
		}
		Print.print("stop doing this");
		
	}
}