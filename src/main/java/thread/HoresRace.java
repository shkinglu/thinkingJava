package thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import  static net.mindview.util.Print.*;

class Horse implements Runnable{
	private static int counter=0;
	private  final int id=counter++;
	private static Random r=new Random(47);
	private static CyclicBarrier cb;
	
	public Horse(CyclicBarrier cb) {
		this.cb=cb;
		
	}
	private int strides=0;
	public synchronized int getValue(){
		return strides;
	}
	@Override
	public void run() {
		try {
		while(!Thread.interrupted()){
			synchronized(this){
				strides+=r.nextInt(3);
			}
		
				cb.await();}//等待直到所有的都做完
			} catch (InterruptedException | BrokenBarrierException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	public String toString(){return "Horse"+id+" ";}
	public String tracks(){
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<getValue();i++)
			sb.append(" *");
		sb.append(id);
		return sb.toString(); //每一步的动作
	}
}




public class HoresRace {
	static  final int FINSH_LINE=75;
	private List<Horse> hores=new ArrayList<Horse>();
	private ExecutorService es=Executors.newCachedThreadPool();
	private CyclicBarrier cb;
	public HoresRace(int NHorse,final int pause) {
		cb=new CyclicBarrier(NHorse, new Runnable() {
			
			@Override
			public void run() {
			StringBuilder s=new StringBuilder();
			for(int i=0;i<FINSH_LINE;i++){
				s.append("=");
			}
			print(s);
			for(Horse h:hores){
				print(h.tracks());
			}
			for(Horse h:hores){
				if(h.getValue()>=FINSH_LINE){
					print(h+"win");
					es.shutdownNow();
					return;
				}
				try {
					TimeUnit.MILLISECONDS.sleep(200);
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
			}
		});
		
		for(int i=0;i<NHorse;i++){
			Horse h=new Horse(cb);
			hores.add(h);
			es.execute(h);
			}
	}
	public static void main(String[]  args) {
		int nHores=7;
		int pause=200;
		if(args.length>0){
			int n=new Integer(args[0]);
			nHores=n>0?n:nHores;
		}
		if(args.length>1){
			int p=new Integer(args[1]);
			pause=p>-1?p:pause;
		}
		new HoresRace(nHores, pause);
	}

}
