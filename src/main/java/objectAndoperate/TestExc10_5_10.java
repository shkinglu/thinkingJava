package objectAndoperate;

import java.util.Random;

interface E2{
	
	public int guess();
}

 class Exc10_5_10 {
	
	
	
	private	class E2Imp implements E2{
		 static final int I=47;
		 public int guess(){
		 return I;
		 }
	
	}
	
	public E2 getE2(){
		
		E2 e2Imp = new E2Imp();
		return e2Imp;
	}
 }	
 public  class TestExc10_5_10{
	public static void main(String[] args) {
		
		  Exc10_5_10 exc10_5_10 = new Exc10_5_10();
		  E2 e2   = exc10_5_10.getE2();
//		  E2Imp e2   = (E2Imp) exc10_5_10.getE2(); 
//		  这句话有编译错误那就证明是完全隐藏了所以也就没有路多态的说法
		  
		 System.out.print(e2.guess()); 
	}
	
}
