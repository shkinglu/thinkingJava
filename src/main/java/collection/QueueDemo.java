package collection;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class QueueDemo {
	public static void printQ(Queue queue){
		if(queue.peek()!=null){
			System.out.print(queue.remove());
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Queue<Integer> queue=new LinkedList<Integer>();
		Random ra=new Random(47);
		for(int i=0;i<10;i++){
			queue.offer(ra.nextInt(i+10));
		
		printQ(queue);
		}
	}

}
