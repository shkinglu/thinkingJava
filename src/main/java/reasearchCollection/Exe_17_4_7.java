package reasearchCollection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Exe_17_4_7 {
	
	public static void main(String[] args){
		
		List<String> aArry=new ArrayList<String>(Collections.nCopies(4, "Blood Blade"));
		List<String> bList=new LinkedList<String>(Collections.nCopies(8, "Asmodel"));
		
		Iterator<String> a=aArry.iterator();
		Iterator<String> b=bList.iterator();
		while(a.hasNext())
		System.out.println(a.next());
			
		while(b.hasNext())
		System.out.println(b.next());
		
		
			
		
	}

}
