package exception;

public class Exe_12_10_21 {

	class BaseballException extends Exception{
		
		
	}
	
	class Foo{
		public Foo() throws BaseballException {
			
			throw  new BaseballException();
		}
	}
	
	class Bar extends Foo{
		
		public Bar() throws BaseballException{
			
		}
	}
	
	public static void main(String[] args) {
		
		

	}

}
