package thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import  static net.mindview.util.Print.*;

class TaskPortion implements Runnable{

	private static int counter=0;
	private int id=counter++;
	private final  CountDownLatch latch;
	public TaskPortion(CountDownLatch latch) {
		this.latch=latch;
	}
	@Override
	public void run() {
		try {
			doWork();
			latch.countDown();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	private void doWork() throws InterruptedException{
		TimeUnit.MILLISECONDS.sleep(200);
		print(this+"compelet");
	}
	public String toString(){
		return String.format("%1$-3d", id);
	}
}

class WaitingTask implements Runnable{
	private static int counter=0;
	private int id=counter++;
	private final  CountDownLatch latch;
	public WaitingTask(  CountDownLatch latch) {
		 this.latch= latch;
	}
	@Override
	public void run() {
	try {
		latch.await();
		print("Lanch barrier passed for"+this);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		print(this+"interrupted");
	}

		
	}
	public String toString(){
		return String.format("%1$-3d", id);
	}
}

public class CountDownLatchDemo {
	static final int SIZE=100;
	public static void main(String[] args) {
		
		ExecutorService executorService=Executors.newCachedThreadPool();
		CountDownLatch latch=new CountDownLatch(SIZE);
			for(int i=0;i<10;i++)
					executorService.execute(new WaitingTask(latch));
			for(int i=0;i<SIZE;i++)
				executorService.execute(new TaskPortion(latch));
			print("Launched all taks");
			executorService.shutdown();
	}

}
