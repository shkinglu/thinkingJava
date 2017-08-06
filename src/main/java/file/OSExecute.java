package file;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class OSExecute {
	
	public static void command(String command){
		boolean error =false;
		try {
			Process process=new ProcessBuilder(command.split(" ")).start();
			BufferedReader resluts=new BufferedReader(new InputStreamReader(process.getInputStream()));
			String s;
			while((s=resluts.readLine())!=null){
				System.out.println(s);
			}
			BufferedReader err=new BufferedReader(new InputStreamReader
									(process.getErrorStream()));
			while((s=err.readLine())!=null){
				System.err.println(s);
				error=true;
			}
		} catch (Exception e) {
			if(!command.startsWith("Ctrl Alt")){
				
			}
		}
	}

}
