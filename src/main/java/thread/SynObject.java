package thread;

import net.mindview.util.Print;

class DualSyn{
	private Object synObject=new Object();
	public synchronized void f() {
		for(int i=0;i<5;i++){
		Print .print("f()");
		Thread.yield();
		}
		
		
	}
	public void g(){
		synchronized (synObject) {
			for(int i=0;i<5;i++){
				Print .print("g()");
				Thread.yield();
			}
		}
	}
}

public class SynObject {

	public static void main(String[] args) {
		final DualSyn dualSyn=new DualSyn();
		 new Thread(){
			 public void run(){
				 dualSyn.f();
			 }
		 }.start();
		 
		 dualSyn.g();
			
		}

}
