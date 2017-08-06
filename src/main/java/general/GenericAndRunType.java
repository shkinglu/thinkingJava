package general;

class Base{
	
}

class Derived extends Base{
	
}
interface OrdinaryGetter{
	Base get();
}

interface DerivedGetter extends OrdinaryGetter{
	
	Derived get();
}

public class GenericAndRunType {
	
	void test(Getter g){
		Getter reslut=g.get();
		GenericGetter gg=g.get();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
