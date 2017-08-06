package rtti;

import static net.mindview.util.Print.*;


interface HasBatteries{
	
}
interface WaterProof{
	
}
interface Shoots{
	
}
class Toy{
	public Toy(){
		
	}
	public Toy(int i){
		
	}
}

class FancyToy extends Toy implements HasBatteries ,WaterProof,Shoots{
	public FancyToy() {
		super(1);
	}
}
public class ToyTest {
	
	static void printInfo(Class c){
		print("Class name:"+c.getName()+" is inferface ? ["+c.isInterface()+"]");
		print("Simple name:"+c.getSimpleName());
		print("Canpnical name:"+c.getCanonicalName());
		}

	public static void main(String[] args) {
		
	
		
		
		
		Class c=null;
		try {
			c=Class.forName("FancyToy");
		} catch (ClassNotFoundException e) {
			print("cannot found FancyToy");
			System.exit(1);
		}
		printInfo(c);
		for(Class face:c.getInterfaces())
			printInfo(face);
			Class up=c.getSuperclass();
			Object obj=null;
			try {
				obj=up.newInstance();//应该是调用默认的无参构造器
			} catch (Exception e) {
				// TODO: handle exception
			}
			printInfo(obj.getClass());
		
	
	}

}
