package collection;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Exc_11_10_18 {
	public static Map<Integer, String> bar=new LinkedHashMap<Integer, String>();
	
	public static Map<Integer, String> foo=new HashMap<Integer, String>();
	static{
		foo.put(1, "1st");
		foo.put(12, "6th");
		foo.put(5, "2rd");
		foo.put(5, "3rd");
		foo.put(5, "7rd");
		foo.put(3, "3rd");
		foo.put(32, "5th");
		foo.put(9,"4th");
	}
	
	public static void main(String[] args){
		
		Integer[] keySet =(Integer[]) foo.keySet().toArray(new Integer[0]);
		System.out.print("before"+Arrays.toString(keySet));
		Arrays.sort(keySet);
		System.out.print("after"+Arrays.toString(keySet));
		
		for(Integer i:keySet){
			bar.put(i, foo.get(i));
		}
		
		System.out.print(bar);
		//这道题目用了很久其实自己的思路是对的，就是最后差了组织
		
		
		
		
	
		
	}



}
