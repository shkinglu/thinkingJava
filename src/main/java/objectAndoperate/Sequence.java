package objectAndoperate;

interface Selector{
	boolean end();
	Object current();
	void next();
}

public class Sequence {
	 private Object[] items;
	 private int next=0;
	 
	 public  Sequence(int size){
		 this.items=new Object[size];
	 }
	public void add(Object x){
		if(next<items.length){
			items[next++]=x;
		}
	}
	
	private class SequenceSelector implements Selector{
		private int i=0;
		
		@Override
		public boolean end() {
			
			return i==items.length;
		}

		@Override
		public Object current() {
			
			return items[i];
		}

		@Override
		public void next() {
			if(i<items.length){
				i++;
			}
			
		}
		
	}
	
	private class ReverseSelector implements Selector{
		private int i=items.length;
		
		@Override
		public boolean end() {
			
			return i==0;
		}

		@Override
		public Object current() {
			
			return items[i-1];
		}

		@Override
		public void next() {
			if(i>0){
				i--;
			}
			
		}
		
	}
	
	public Selector selector(){
		return new SequenceSelector();
	}
	
	public  Selector reverseSelector(){
		return new ReverseSelector();
	}
	
	public static void  main(String[] args) {
		Sequence se=new Sequence(10);
		for(int i=0;i<10;i++)
			se.add(Integer.toString(i));
		Selector selector= se.reverseSelector();
		
		while(!selector.end()){
			System.out.print(selector.current()+" ");
			selector.next();
		}
	}
}
