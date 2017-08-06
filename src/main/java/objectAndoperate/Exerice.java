package objectAndoperate;

public class Exerice {
	
	static class  ExericeOne{
			
	static	 public  int i;
		 public String j;
	}
	
	
	static class ExericeSix {

		int storage(String s) {
			return s.length() * 2;
		}
	}
  
	 static int result=0;
	
	static void testReslut(int testval,int target){

		
		if(testval>target){
			result=+1;
		}
		else if (testval<target) {
			result=-1;
		}
		else 
			result=0;
	}
	
	
	
	public static void main(String[] args){
/*		ExericeOne	one=new ExericeOne();
		ExericeOne	one1=new ExericeOne();
		
		float i=3.4028235E38f;
		System.out.println("i= "+i);
		
		
		ExericeSix exericeSix = new ExericeSix();
		System.out.println( one.i);
		System.out.println(one1.i);
		System.out.println(exericeSix.storage("lilian"));
		*/
		testReslut(10, 5);
		System.out.println(result);
		testReslut(5, 10);
		System.out.println(result);
		testReslut(10, 5);
		System.out.println(result);
		testReslut(5, 5);
		System.out.println(result);
	}
	
	
	

}


