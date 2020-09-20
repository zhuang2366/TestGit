package test;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//CC a=new CC(5);
		int i=1;
		do {
			
			System.out.println(i);
			i++;
		} while (i==0);

	}

}
class CC extends endends
{
	CC(int a) {
		super(a);
		
	}

	
}
class endends {
	int a;
	endends(int a){
		this.a=a++;
		System.out.print(a);
		
		
	}

}
