package Leetcode.Math;

public class ReverseInteger_7 {
	
	public int reverse(int x){

		int i=1, num=Math.abs(x), reverse=0;
		while(num>0){
			int temp = reverse*10 + num%10*i;
			if (temp<(long)reverse*10)
				return 0;
			reverse = temp;
			num/=10;
		}
		if (x<0)
			reverse*=-1;
		return reverse;
	}
	
	public static void main(String[] args){
		ReverseInteger_7 obj = new ReverseInteger_7();
		System.out.println(obj.reverse(1534236469));
	}

}
