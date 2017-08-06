package thread;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EvenChecker implements Runnable{
	private IntGenertor g;
	private final int id;
	
	public EvenChecker(IntGenertor g,int id){
		this.g=g;
		this.id=id;
	}
		@Override
		public void run() {
			while(!g.isCancled()){
				int val=g.next();
				if(val%2!=0){
					System.out.println("val is note even");
					g.cancel();
				}
			}
			
		}
		
		public static void test(IntGenertor g,int count){
			System.out.println("Press Control C ");
			ExecutorService executorService=Executors.newCachedThreadPool();
			for(int i=0;i<count;i++)
				executorService.execute(new EvenChecker(g, i));
			executorService.shutdown();
		}
		
		public static void  test (IntGenertor gp){
			test(gp,10);
		}
}
