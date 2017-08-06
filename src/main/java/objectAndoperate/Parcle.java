package objectAndoperate;

interface Contents{
	int value();
}

class Parcle4 {
	private  class ContentsIMp implements Contents {
		private int i=11;
		public int value(){
			return i;
		}
	}
	
	public  Contents Content(){
		return new ContentsIMp();
	}
}	
	public class  Parcle{
		public static void main(String[] args){
		Parcle4 pa=new Parcle4();
		/*Parcle.Contents c=pa.new Contents();//好复杂 为什么要这样做*/
		
	}
	
}
