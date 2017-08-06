package exception;

class BaseballException extends Exception{}
class Fouls extends BaseballException{}
class Strike extends BaseballException{}

abstract class Inning{
	public Inning()throws BaseballException{
		
	}
	public void event() throws BaseballException{
		
	}
	public abstract void atBat() throws Fouls ,Strike;
	public void walk(){
		
	}
}

class StromlException extends Exception{}
class RainedOut extends StromlException{}
class PopFoul extends Fouls{}

interface Storm{
	public void event() throws RainedOut;
	public void raindHard() throws RainedOut;
}
public class StromyInning  extends Inning implements Storm{
	public StromyInning() throws RainedOut,BaseballException{}
	public StromyInning(String s) throws RainedOut,BaseballException{}
	
	public void event() {
		
	}
	public void atBat() throws PopFoul{
		
	}
	public void raindHard() throws RainedOut{
		
	}
	
	public static void main(String[] args) {
		try {
			Inning inning=new StromyInning();
			inning.atBat();
		
		}catch (PopFoul e) {
			System.out.println("catch PopFoul ");
		}catch (RainedOut e) {
			System.out.println("catch RainedOut ");
		}catch (BaseballException e) {
			System.out.println("catch RainedOut ");
		}
			
	}

}
