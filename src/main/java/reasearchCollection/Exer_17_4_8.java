package reasearchCollection;






class  Slist<E>  {
	private Link<E> headLink=new Link<E>(null);

	public String toString(){
		return "todo";
	}
	
	
}

	class SlistIterator<E>{
		Link<E> current;
		
	public	SlistIterator(Link<E> link){
		current=link;
	}
	
	public Link<E> next(){
		current=current.next;
		return current;
		
	}
	
	public boolean hasNext(){
		return current.next!=null;
	}
	
	public void insert(E e){
		
		current=current.next;//如何理解
	}
	
	public void remove(E e){
		
	}
	
	
	}

class Link<E>{
	E e;
	Link<E> next;
	
	public Link(E e,Link<E> next){
		this.e=e;
		this.next=next;
	}
	public Link(E e){
		this(e,null);
	}
}

public class Exer_17_4_8 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
