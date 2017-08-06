package general;

import java.util.*;



interface Processor<T,E extends Exception>{
	void process(List<T> relcollection ) throws E;
}	

class ProcessorRunner<T,E extends Exception> extends  
ArrayList<Processor<T,E>>	{ 
	
}
public class ThrowGenericException {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
