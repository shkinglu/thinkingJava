package general;

public class StroyCharacter {
	private static  long couter=0l;
	private final long id  =couter++;
	private String name;
	private int sex;
	
	public String toString() {
		return getClass().getSimpleName()+" "+name+" "+id;
	}

}
