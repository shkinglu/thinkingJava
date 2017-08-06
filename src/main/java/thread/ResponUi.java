package thread;

class UnresponUI{
	private volatile double d=1;
	public  UnresponUI() throws Exception {
		while(d>0)
			d=(d+Math.PI+Math.E)/d ;
		System.in.read();
			
	}
	
}

public class ResponUi extends Thread {
	private  static volatile double d=1;
	
	public ResponUi(){
		setDaemon(true);
		start();
	}
	public void run(){
		while(true)
			d=(d+Math.PI+Math.E)/d ;
	}

	public static void main(String[] args) throws Exception {
		new ResponUi();
		System.in.read();
		System.out.println(d);

	}

}
