package thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;

import  static net.mindview.util.Print.*;

class  PriorityTask implements Runnable,Comparable<PriorityTask>{
	private Random r=new Random(47);
	private static int count=0;
	private  final  int id=count++;
	private int priortiy;
	protected static List<PriorityTask> taskList=new ArrayList<PriorityTask>();
	public PriorityTask(int priortiy ) {
		this.priortiy=priortiy;
		taskList.add(this);
	}
	

	@Override
	public int compareTo(PriorityTask o) {
		
		return priortiy<o.priortiy ?1:(priortiy>o.priortiy ? -1:0);
	}

	@Override
	public void run() {
		try {
			TimeUnit.MILLISECONDS.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		print(this);
		
	}
	
	public String toString(){
		return String.format("[%1$-3d]", priortiy)+"Task"+id;
	}
	
	public String summary(){
		return "("+id+":"+priortiy+")";
	}
	public static class EndSentinel extends PriorityTask{
		private ExecutorService es;
		public EndSentinel(ExecutorService es) {
			super(-1);
			this.es=es;
		}
		public void run(){
			int count=0;
			for(PriorityTask pt: taskList ){
				print(pt.summary());
				if(++count%5==0)
					print();
			}
			print();
			print(this+"Calling shutdown");
			es.shutdownNow();
		}
	}
}

class  PriorityTaskproducer implements Runnable{
	private Random r=new Random(47);
	private Queue<Runnable> queue;
	private ExecutorService es;
	public PriorityTaskproducer( Queue<Runnable> queue,ExecutorService es) {
		this.queue=queue;
		this.es=es;
	}
	@Override
	public void run() {
		for(int i=0;i<20;i++){
			queue.add(new PriorityTask(r.nextInt(10)));
			Thread.yield();
		}
		try {
			for (int i = 0; i < 10; i++) {
				TimeUnit.MILLISECONDS.sleep(250);
				queue.add(new PriorityTask(10));
			}
			for (int i = 0; i < 10; i++) {
				queue.add(new PriorityTask(i));
			}
			queue.add(new PriorityTask.EndSentinel(es));
		} catch (Exception e) {
			// TODO: handle exception
		}
		print("finished product");
	}
	
}


class PriorityTaskCustomer implements Runnable{
	private PriorityBlockingQueue<Runnable>  pbQuee;
	public PriorityTaskCustomer( PriorityBlockingQueue<Runnable>  pbQuee ) {
	this.pbQuee=pbQuee;
	}
	@Override
	public void run() {
		try {
		while(!Thread.interrupted()){
			
				pbQuee.take().run();
			} }catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		print("Finshed  PriorityTaskConsumer");
		}
		
	
	
}

public class PriorityBlockDemo {

	public static void main(String[] args) {
		PriorityBlockingQueue<Runnable> queue=new PriorityBlockingQueue<Runnable>();
			Random r=new Random(47);
			ExecutorService es=Executors.newCachedThreadPool();
			es.execute(new PriorityTaskproducer(queue, es));
			es.execute(new PriorityTaskCustomer(queue));

	}

}
