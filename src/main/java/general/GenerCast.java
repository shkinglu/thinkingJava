package general;


import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.List;

class FixedSizeStack<T>{
	private int i=0;
	private Object[] storage;
	public  FixedSizeStack( int size) {
		storage=new Object[size];
	}
	public void push(T item) {
		storage[i++]=item;
	}
	
	@SuppressWarnings("unchecked")
	public T pop() {
		return   (T)storage[--i];
	}
}

public class GenerCast {
	
	public void f(String[] args)throws Exception{
		ObjectInputStream  in=new ObjectInputStream(new FileInputStream(args[0]));
		
	}
	

	public static void main(String[] args) {
		

	}

}
