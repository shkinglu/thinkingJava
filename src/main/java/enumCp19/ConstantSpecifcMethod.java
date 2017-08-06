package enumCp19;

import java.text.DateFormat;
import java.util.Date;

public enum ConstantSpecifcMethod {
	DATE_TIEM{
		
		String getInfo(){
			return DateFormat.getDateInstance().format(new Date());
		}
	},
	
	CLASSPATH{
		String  getInfo(){
			return System.getProperty("CLASSPATH");
		}
	}
	
	;
	//一定要有个抽象方法
	public static void main(String[] args) {
		for(ConstantSpecifcMethod cs:values()){
			System.out.println();
		}

	}

}
