package general;

import java.util.ArrayList;
import java.util.List;

  class Fruit{
	
}
 class Apple extends Fruit{
	
}
class Orange extends Fruit{
	
}

public class GenericsAndCov<T> {
	private T value;
	public GenericsAndCov(){
		
	}
	public GenericsAndCov(T val ){
		this.value=val;
	}
	
	

	public T getValue() {
		return value;
	}
	public void setValue(T value) {
		this.value = value;
	}
	
	public boolean equals(Object obj){
		return value.equals(obj);
	}
	public static void main(String[] args) {
		
		GenericsAndCov<Apple> apple=new GenericsAndCov<Apple>(new Apple());
		Apple d=apple.getValue();
		
		apple.setValue(d);
			
		
		GenericsAndCov<? extends Fruit> apple1=apple;
	}

}
