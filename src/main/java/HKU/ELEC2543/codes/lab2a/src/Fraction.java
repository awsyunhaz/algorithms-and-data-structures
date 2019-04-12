public class Fraction {
    
	private int num, denom;
	
	public Fraction(int n, int d){
		num = n;
		denom = d;
		if (denom == 0) denom = 1;
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
        if(a == 0 || b == 0) return a+b; // base case
        return gcd(b,a%b);
    }

}
