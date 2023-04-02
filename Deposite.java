package bank;

web
public class Deposite {
	double amt2;
	Update d = new Update();
	AddAccount a=new AddAccount();
	
	//deposite code
	public double deposite(){
		
		if(d.accno2==a.accno1){
			amt2=a.ini_amt+d.amt1;
		}else{
			System.out.println("ACCOUNT DOES NOT EXIST");
		}
		return amt2;
	}
	
	
}
