package reasearchCollection;

import java.util.Iterator;

import general.Generator;

public class Letters implements Generator<Pair<Integer, String>> ,Iterable<Integer>{

	private int size=9;
	private int number=1;
	private char letter='A';
	
	@Override
	public Pair<Integer, String> next() {
		
		return new Pair<Integer, String>(number++, " "+letter++);
	}

	@Override
	public Iterator<Integer> iterator() {
	
		return new Iterator<Integer>() {

			@Override
			public boolean hasNext() {
				// TODO Auto-generated method stub
				return number<size;
			}

			@Override
			public Integer next() {
				// TODO Auto-generated method stub
				return number++;
			}
			
		};
	}

}
