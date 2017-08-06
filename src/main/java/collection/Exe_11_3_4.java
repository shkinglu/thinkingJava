package collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.TreeSet;

class Generator {
	int key = 0;

	public String next() {
		switch ((key+7)%7) {
		
		case 0:
			key++;
			return "Snow White";
		case 1:
			key++;
			return "Bashful";
		case 2:
			key++;
			return "Doc";
		case 3:
			key++;
			return "Dopey";
		case 4:
			key++;
			return "Grumpy";
		case 5:
			key++;
			return "Happy";
		case 6:
			key++;
			return "Sleepy";
		default:
		case 7:
			key++;
			return "Sneezy";
		}
	}

	public void fillA(String[] a) {
		for (int i = 0; i < a.length; i++) {
			a[i] = next();
		}
	}

	public Collection fill(Collection<String> c, int n) {
		for (int i = 0; i < n; i++)
			c.add(next());
		return c;
	}
}
	public class Exe_11_3_4{
	public static void main(String[] args) {
		Generator gen = new Generator();
		String[] a = new String[10];
		gen.fillA(a);
		for(String s : a)System.out.println(s + ",");
		System.out.println();
		System.out.println(gen.fill(new ArrayList<String>(), 10));
		System.out.println(gen.fill(new LinkedList<String>(), 10));
		System.out.println(gen.fill(new HashSet<String>(),10));
		System.out.println(gen.fill(new LinkedHashSet<String>(),10));
		System.out.println(gen.fill(new TreeSet<String>(),10));
	}
	
}
