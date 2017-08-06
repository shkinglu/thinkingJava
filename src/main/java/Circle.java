

	interface Cycle {
		int wheels();
	}

	interface CycleFactory {

		Cycle getCycle();
	}

	class UniCycle implements Cycle {

		public int wheels() {

			return 1;
		}

	}

	class BiCycle implements Cycle {

		public int wheels() {

			return 2;
		}

	}

	class TriCycle implements Cycle {

		public int wheels() {

			return 3;
		}

	}
	
	class  UniCycleFactoryImp implements  CycleFactory{
		public	Cycle getCycle(){
			return  new UniCycle();
		}
	}
	
	class  BiCycleFactoryImp implements  CycleFactory{
		public	Cycle getCycle(){
			return  new BiCycle();
		}
	}
	class  TriCycleFactoryImp implements  CycleFactory{
		public	Cycle getCycle(){
			return  new TriCycle();
		}
	}
	
	
	public class Circle {
		
		public static void showWheels(CycleFactory  cf ){
			Cycle cy=cf.getCycle();
			System.out.println("I am  "+cy.getClass().getSimpleName()+"I have"+cy.wheels()+" wheel.");
		}
	public static void main(String[] args){
	
		showWheels(new TriCycleFactoryImp() );
		showWheels(new BiCycleFactoryImp() );
	}
	
}
