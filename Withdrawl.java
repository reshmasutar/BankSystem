package bank;

public class Withdrawl {
	double amt2;
	Update d = new Update();
	AddAccount a=new AddAccount();
		
	//withdrawl code
		public double withdrawl(){
			
			if(d.accno2==a.accno1){
				if(d.amt1<=a.ini_amt){
					amt2=a.ini_amt-d.amt1;
			}else{
				System.out.println("INSUFFICIENT BALANCE");
			}
			}else{
				System.out.println("ACCOUNT DOES NOT EXIST");
			}
			return amt2;
		}

}
