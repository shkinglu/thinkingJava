package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


public class BasicConcept  {
	

	
	public static void main(String[] args){
		Collection<Integer> collection=new ArrayList<Integer>(Arrays.asList(1,2,3,4));
		Integer[] month={5,6,7,8,9,10,11,12};
		collection.addAll(Arrays.asList(month));
		Collections.addAll(collection,12,13,15);
 
	}
}
