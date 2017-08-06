package objectAndoperate;

public class Dog {
	
	
	private String name;
	private String says;
	

	public static void main(String[] args) {
		
		Dog spot=new Dog();
		Dog scruffy=new Dog();
		
		spot.name="spot";
		spot.says="Ruff";
		
		spot.name="scruffy";
		spot.says="Wruff";
		
		System.out.println("spot say "+spot.says);
		
		System.out.println("scruffy say "+ scruffy.says);
		
		Dog index=spot;
		
		System.out.println("index==spot "+(index==spot));
		System.out.println("index equals spot "+(index.equals(spot)));
	}

}
