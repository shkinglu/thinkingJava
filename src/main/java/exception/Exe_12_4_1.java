package exception;

public class Exe_12_4_1 {
	
	class Myexception extends Exception{
		
		public  Myexception(String msg){
			super(msg);
		}
	}	
		
	public void f() throws Myexception{
		System.out.println("Throw Exception fromn f()");
		throw new Myexception("Oops!");
	}
		
	public static void main(String[] args){
		Exe_12_4_1 exe_1 = new Exe_12_4_1();
		try {
			exe_1.f();
		} catch (Myexception e) {
			e.printStackTrace(System.out);
		}
		finally{
			System.out.println("finally I did");
		}
	}
	
}
