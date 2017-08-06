package general;

import java.util.Arrays;
import java.util.List;



public class GenericReading {
	
	static <T>  T readExact(List<T> list){
		return list.get(0);
	}
	
	static List<Apple> apples=Arrays.asList(new Apple(),new Apple());
	static List<Fruit> fruit=Arrays.asList(new Fruit(),new Apple());
	
	static void f1(){
		Apple a=readExact(apples);
		Fruit f=readExact(fruit);
		f=readExact(apples);
	}
	
	static class Reader<T>{
		T readExact(List<T> list ){
			return list.get(0);
		}
		static void f2(){
			Reader<Fruit> a=new Reader<Fruit>();
			a.readExact(fruit);
			
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
