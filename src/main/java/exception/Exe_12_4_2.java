package exception;

public class Exe_12_4_2 {
	
	public void f(Exe_12_4_2 e){
		System.out.println(e.toString());
	}

	public static void main(String[] args) {
		Exe_12_4_2 exe_2 = new Exe_12_4_2();
		
		
		exe_2.f(exe_2);

	}

}
