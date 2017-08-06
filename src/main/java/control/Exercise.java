package control;

import  static net.mindview.util.Print.*;




public class Exercise {
	
	void fictionOne(){
		System.out.print("One");
	}
	
void fictionTwo(){
	  fictionOne();
	  fictionOne();
	}
	
 
 

	@Override
	protected void finalize() throws Throwable {
	 System.out.println("finalize");
	super.finalize();
}

	public static void main(String[] args) {
	 print("hellow");//
		new Exercise();
		System.gc();
	
	}
}
