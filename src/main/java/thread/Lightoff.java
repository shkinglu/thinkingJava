package thread;

public class Lightoff  implements Runnable{

	public int countDown=10;
	private static int taskCount=0;
	private final int id=taskCount++;
	
	 public Lightoff() {
		// TODO Auto-generated constructor stub
	}
	
	public Lightoff(int countDown){
		this.countDown=countDown;
	}
	
	public String status() {
		return "#"+id+"("+(countDown>0? countDown:"Lightoff")+")";
	}
	
	@Override
	public void run() {
		while(countDown-->0){
			System.out.println(status());
			Thread.yield();
		}
		
	}

}
