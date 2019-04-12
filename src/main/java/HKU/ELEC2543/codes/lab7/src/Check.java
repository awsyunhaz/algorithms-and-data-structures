public class Check {
	
	private String payee;
	private static int serial_number = 1001;
	private int number;
	private int amount;
	
	public Check(String s, int a){
		payee = s;
		amount = a;
		number = serial_number;
		serial_number ++;
	}
	
	public String toString(){
		return  "Check No: " + number + ", Payee: " + payee + ", Amount: " + amount;
	}
}
