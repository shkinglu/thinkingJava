package general;

import java.util.Iterator;
import java.util.Random;

public class StoryCharactersGenerator implements Generator<StroyCharacter>,Iterable<StroyCharacter> {

	private Class[] type={GoodGuys.class,BadGuys.class};
	private static Random ra=new Random(47);
	private int size=0;
	
	public StoryCharactersGenerator(){
		
	}
	
	public StoryCharactersGenerator(int size){
		this.size=size;
	}
	
	public StroyCharacter next(){
		try {
			return (StroyCharacter) type[ra.nextInt(type.length)].newInstance();
					}
		catch(Exception e){
			throw new RuntimeException(e);
		}
	}//非常粗糙啊这如何填充详细信息
	
	class StroyCharacterIterator implements Iterator<StroyCharacter>{
		int count=size;
		
		@Override
		public boolean hasNext() {
			
			return count>0;
		}

		@Override
		public StroyCharacter next() {
			 count--;
			return  StoryCharactersGenerator.this.next();
		}
		
	}
	
	@Override
	public Iterator<StroyCharacter> iterator() {
	
		return new StroyCharacterIterator();
	}
		public static void main(String[] args){
		StoryCharactersGenerator sGenerator = new StoryCharactersGenerator();
		for(int i=0;i<5;i++){
			System.out.println(sGenerator.next());
		}
		for(StroyCharacter c:new StoryCharactersGenerator(5)){
			System.out.println(c);
		}
		}
	
}
