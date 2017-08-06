package general;

import java.util.Collection;



public class Fill2Test {
	
	public static void main(String[] args) {
		System.out.println("AA");

	}
}

interface Addable<T> {
	void add(T t);
}
class Fill2{
	public static <T> void fill(Addable<T> addable,Class<? extends T> classtoken,int size) {
		for(int i=0;i<size;i++){
			try {
				addable.add(classtoken.newInstance());
			} catch (Exception e) {
				throw new  RuntimeException(e);
			}
		}
	}
	
	public static <T> void fill(Addable<T> addable,Generator<T> generator,int size) {
		for(int i=0;i<size;i++){
			addable.add(generator.next());
		}
	}
	
	
}

abstract class AddableCollectionAdapter<T> implements Addable{
	private Collection<T> c;

	public AddableCollectionAdapter(Collection<T> c) {
		
		this.c = c;
	}
	
}
