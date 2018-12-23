package cn.edu.leetcode;
/**
* @author 作者
* @version 创建时间：2018年12月17日 下午5:25:21
* 类说明
*/
public class myPow {
	static double myPow1(double x, int n) {
		double m=0.0;
		if ((x<100&&x>-100)&&(n>=Integer.MIN_VALUE&&n<=Integer.MAX_VALUE)) {
			if(n == 0)
	            return 1;
	        double half=0;
	        int q=Math.abs(n);
	        if((q&1)==1)
	        {
	            half = myPow1(x, q/2);
	            m=x*half*half;
	        }
	        else
	        {
	            half =myPow1(x, q/2);
	            m=half*half;
	        }		
	        if (n<0) {
				m=1/m;
			}
		} else if (n>Integer.MAX_VALUE) {
			
		}else {
			
		}
		return m;
	}
	static double myPow2(double x,int n)
	{
		double m=1;
		/*int i=1;*/
		if (n==0) {
			return 1;
		}
		int p=Math.abs(n);
		for (int i = 1; i <=p; i++) {
			m=m*x;
		}
		if (n<0) {
			m=1/m;
			return m;
		}else{
			return m;
		}
	}
	public static void main(String[] args) {
		System.out.println(myPow1(2.00,-3));
		System.out.println(myPow2(2.00, -3));
		System.out.println(Math.pow(2.00,-3));
	}
}
