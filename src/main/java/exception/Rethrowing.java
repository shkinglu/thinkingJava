package exception;

public class Rethrowing {
	public static void f() throws Exception{
		System.out.println("originating the exception in f()");
		throw new Exception("thorwn from f()");
	}
	
	public static void   g() throws Exception {
		try {
			f();
		} catch (Exception e) {
			System.out.println("inside g() ,e.printStackTrace()");
			e.printStackTrace(System.out);
			throw e;
		}
	}
	public static void   h() throws Exception{
		try {
			f();
		} catch (Exception e) {
			System.out.println("inside h() ,e.printStackTrace()");
			e.printStackTrace(System.out);
			throw (Exception)e.fillInStackTrace();
		}
	}
	
	public static void main(String[] args){
		try {
			g();
		} catch (Exception e) {
			System.out.println("Main:printStackTrace()");
			e.printStackTrace(System.out);
		}
		try {
			h();
		} catch (Exception e) {
			System.out.println("Main:printStackTrace()");
			e.printStackTrace(System.out);
			
		}
	}
}
