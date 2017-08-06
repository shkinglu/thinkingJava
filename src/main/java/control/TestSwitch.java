package control;

import java.util.Random;
import  net.mindview.util.Print;
public class TestSwitch {

	public static void main(String[] args) {

		Random random = new Random(47);
		for(int i=0;i<100;i++){
			int c=random.nextInt(26)+'a';
			
			System.out.print((char)c+", "+c+" :");
			switch(c){
			case 'a':
			case 'b':	System.out.print("2b");break;
			case 'i':	
			case 'o':	System.out.print("vowel");break;
			case 'e':	
				default: System.out.print("constant");
			}
		}

	}

}
