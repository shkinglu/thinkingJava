package general;

public class LinkedStack <T>{
	private class Node{
		T item;
		Node next;
		boolean end(){
			return item==null&&next==null;
		}
		Node(){
			item=null;
			next=null;
		}
		Node(T item, Node next){
			this.item=item;
			this.next=next;
		}
	 
	}
	private Node top=new Node();
	public void push(T item){
		top=new Node(item,top);
	}
	public T pop(){
		T reTust=top.item;
		if(!top.end()){
			top=top.next;
		}
		return reTust;
	}
	public static void main(String[] args){
		LinkedStack<String> lss= new LinkedStack<String>();
		for(String s: "Pharde on stun!".split(" "))
			lss.push(s);
		String s;
		while((s=lss.pop())!=null)
			System.out.println(s);
	}
		
}
