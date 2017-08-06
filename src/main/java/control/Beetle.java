package control;

import static net.mindview.util.Print.*;


class Insect{
	private int i=9;
	protected int j;
	
	Insect(){
		print("i ="+i+"j="+j);
		j=39;
		
	}
	
	private static int x1=printInt("static Insect.x1 initialized");

	 static int printInt(String string) {
		print(string);
		return 47;
	}
}

public class Beetle  extends Insect {
	private int k=printInt("static Beetle.k initialized");
	private static int x2=printInt("static Beetle.x2 initialized");
	Beetle(){
		print("k ="+k);
		print("j ="+j);
	}
	public static void main(String[] args) {
		print("Beetle start initialized");
		 Beetle beetle = new Beetle();
		 
		 print("Beetle1 start initialized");
		 Beetle beetle1 = new Beetle();//证明加载只初始化一次
	

	}

}
