package file;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

public class Exe_18_6_7 {

	public static void printString(String fileName) throws IOException{
		BufferedReader bufferedReader=new BufferedReader(new FileReader(fileName));
		LinkedList<String> llist=new LinkedList<String>();
		
		String s;
		StringBuilder sb=new StringBuilder();
		while((s=bufferedReader.readLine())!=null){
			
			llist.add(s.toUpperCase());
		}
		Collections.reverse(llist);
		System.out.println(llist);
		
	}
	
	public static void main(String args[]) throws IOException{
		printString("/home/jack/git-completion.bash");
	}
	
}
