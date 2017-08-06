package control;




public class ExerciseThree {
	
	public static void main(String[] args) {
		
		
		for(int i=3;i<100;i++){
			boolean flag=true;
			for(int j=i-1;j>1;j--){
				if(i%j==0){
					flag=false;
					break;
				}
			
			}
			if(flag)
			System.out.print(i+" ");
		}
	}	
}
