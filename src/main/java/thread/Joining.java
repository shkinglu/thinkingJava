package thread;

import static net.mindview.util.Print.*;

class Sleeper extends Thread{
	private int duration;
	public Sleeper(String name,int sleeptime){
		super(name);
		this.duration=sleeptime;
		start();
	}
	
	public void run(){
		try {
			sleep(duration);
			
		} catch (InterruptedException e) {
			print(getName()+"was interrupted"+"isInterrupted"+isInterrupted());
			return;
		}
		print(getName()+"has awskened");
	}
}

class Joiner extends Thread{
	private Sleeper sleeper;
	public Joiner(String name ,Sleeper sleeper){
		super(name);
		this.sleeper=sleeper;
		start();
	}
	
	public void run(){
		try {
			sleeper.join();
		} catch (InterruptedException e) {
			print("InterRupted");
		}
		print(getName()+" jion complete");
	}
}

public class Joining {

	public static void main(String[] args) {
		Sleeper sleepy=new Sleeper("Sleepy", 1500);
		Sleeper	grumpy=new Sleeper("Grumpy", 1500);

		Joiner dopey=new Joiner("dopey", sleepy);
		Joiner doc=new Joiner("Doc", grumpy);
		
		grumpy.interrupt();
	}

}
