package general;

class OrdSetter{
	void set(Base b){
		System.out.println("OrdSetter set Base b");
	}
}

class DriSetter extends OrdSetter{
	void set(Derived b){
		System.out.println("DriSetter set Derived D");
	}
}

public class OrdinaryArgus {

	public static void main(String[] args) {
		Base b=new Base();
		Derived d=new Derived();
		DriSetter ds=new DriSetter();
		ds.set(d);
		ds.set(b);

	}

}
