package enumCp19;
import static  net.mindview.util.Print.*;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Set;
import java.util.TreeSet;

import net.mindview.util.OSExecute;

enum Expoler{
	Here,There
}

public class Reflection {
	public static Set<String> analyze(Class<?> enumClass){
		print("------Analyzing"+enumClass+"----");
		print("Interface:");
		for(Type t:enumClass.getGenericInterfaces())
			print(t);
		print("Base:"+enumClass.getSuperclass());
		print("Methods:");
		Set<String> methods=new TreeSet<String>();
		for(Method m:enumClass.getMethods())
			methods.add(m.getName());
		print(methods);
		return methods;
			
	}
	
	public static void main(String[] args){
		Set<String> expolerMehods=analyze(Expoler.class);
		Set<String> enumMehods=analyze(Enum.class);
		
		print("Expoler.containAll(Enum)"+expolerMehods.containsAll(enumMehods));
		
		print("Expoler remove all");
		expolerMehods.removeAll(enumMehods);
		
		print (expolerMehods);
		OSExecute.command("javap Expoler");
		
	}
}
