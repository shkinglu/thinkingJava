package general;

import java.lang.reflect.InvocationTargetException;


class Hero{
		private String name;
		private int power;
		public Hero(){
			
		}
		public Hero(String name ){
			this.name=name;
		}
		public Hero(int power ){
			this.power=power;
		}
	}
	
class Asmodel extends Hero{
		
	}
	public class Exc_15_22<T>{
		Class<?> kind;
	public  Exc_15_22(Class<?> kind){
		this.kind=kind;
	}
	public Object create(String typeName) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		
		return Class.forName(typeName).newInstance();
	}
	public Object create(String typeName,String... args) throws InstantiationException, IllegalAccessException,
																ClassNotFoundException, IllegalArgumentException, InvocationTargetException, 
																NoSuchMethodException, SecurityException {
	
		switch (args.length) {
		case 1:return Class.forName(typeName).getConstructor(args[0].getClass()).newInstance(args[0]);
		case 2:return Class.forName(typeName).getConstructor(args[0].getClass(),args[1].getClass()).newInstance(args[0],args[1]);
			

		
		}
		return null;
	
	}
		
}
