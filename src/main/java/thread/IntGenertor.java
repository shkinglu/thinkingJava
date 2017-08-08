package thread;

public abstract class IntGenertor {
 private volatile boolean canceled=false;
 public abstract int  next() ;
 public void cancel(){
	 canceled=true;
 }
 public boolean isCancled() {
	return canceled;
}
}
