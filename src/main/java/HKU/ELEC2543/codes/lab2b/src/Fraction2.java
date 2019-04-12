public class Fraction2 {
    
	private int num, denom;
	
	public Fraction2(int n, int d){
		num = n;
		denom = d;
		if (denom == 0)
			denom = 1;
		if (num*denom < 0){
			num = -Math.abs(num);
			denom = Math.abs(denom);
		}
		if (gcd(num,denom) != 1){
			int x = gcd(num,denom);
			num /= x;
			denom /= x;
		}
	}
	
	public double value(){
		return (num/denom);
	}
	
	public String toString(){
		String result = Integer.toString(num) + '/' + Integer.toString(denom);
		return result;
	}
    
	private static int gcd(int a, int b) {
        if(a == 0 || b == 0)
        	return a+b; // base case
        return gcd(b,a%b);
    }

	public void square(){
		num *= num;
		denom *= denom;
	}
	
	public Fraction2 copy(){
		Fraction2 cop = new Fraction2(num,denom);

		return cop;
	}
	
	public Fraction2 inverse(){
		Fraction2 inv = new Fraction2(num,denom);
		int temp;
		
		temp = inv.num;
		inv.num = inv.denom; 
		inv.denom = temp;
		
		if (inv.denom < 0){
			inv.denom *= -1;
			inv.num *= -1;
		}
		
		return inv;
	}
}
