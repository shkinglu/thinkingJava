package objectAndoperate;


interface E1{
	public void doS();
}

public class Exc10_5_9  {
	
	private E1  doSometh() {
		
		return new  E1 (){
			public void doS(){
				System.out.print("E1");
			}
			
		};
		/*class E1Imp implements  E1 {
			public void doS(){
				System.out.print("E1");
			}
		}
		return new E1Imp();*/
	}
	

	public static void main(String[] args) {
		Exc10_5_9 exc10_5_9 = new Exc10_5_9();
		exc10_5_9.doSometh().doS();
	}

}
