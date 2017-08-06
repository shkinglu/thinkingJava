package thread;

import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;

class Toast {
	private enum States {
		DRY, BUTTED, JAM
	}

	private States states = States.DRY;
	private final int id;

	public Toast(int id) {
		this.id = id;
	}

	public void jam() {
		states = States.JAM;
	}

	public void butted() {
		states = States.BUTTED;
	}

	public States getStates() {
		return states;
	}

	public int getId() {
		return id;
	}

	public String toString() {
		return "Toast " + id + states;
	}

}

class ToastQueue extends LinkedBlockingQueue<Toast> {

}

class Toaster implements Runnable {
	private ToastQueue toastQ;
	private int count = 0;
	private Random r = new Random(47);

	public Toaster(ToastQueue toastQ) {
		this.toastQ = toastQ;
	}

	@Override
	public void run() {
		try {
			while (!Thread.interrupted()) {
				Toast toast = new Toast(count++);
				toastQ.put(toast);
			}
		} catch (Exception e) {
			System.out.println("interrupted");
		}

	}
}

class ButterAndJamer implements Runnable {
	private ToastQueue toastQ,buttAndJam;
	public  ButterAndJamer (ToastQueue toastQ, ToastQueue buttAndJam){
		this.buttAndJam=buttAndJam;
		this.toastQ=toastQ;
	}
	
	@Override
	public void run() {
		try {
			while(!Thread.interrupted()){
		  
			Toast t=toastQ.take();
			 t.jam();
			 t.butted();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   }
	}



public class Toast_Exe29 {

}
