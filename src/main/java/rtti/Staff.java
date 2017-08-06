package rtti;

import java.util.ArrayList;

public class Staff extends ArrayList<Position> {
	
	public void add(String title,Person person) {
		add(new Position(title, person));
	}
	public void add(String... titles){
		for(String title:titles){
			add(new Position(title));
		}
	}
	public Staff(String... titles){
		add(titles);
	}
	
}
