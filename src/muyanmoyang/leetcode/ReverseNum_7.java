package muyanmoyang.leetcode;

import java.math.BigInteger;
import java.util.Stack;

/**
 *  Reverse digits of an integer.
	Example1: x = 123, return 321
	Example2: x = -123, return -321
 * @author hadoop
 *
 */
public class ReverseNum_7 {
	public static void main(String[] args) {
		ReverseNum_7 r = new ReverseNum_7() ;
		System.out.println(r.reverse(123)) ;
	}
	public int reverse(String x) {
        Stack<String> stack = new Stack<String>() ;
        String str ;
        BigInteger big = new BigInteger(x);
        if(big.compareTo(new BigInteger("0")) == 1){
        	str = big + "" ;
        	for(int i=0; i<str.length(); i++){
        		stack.push((str.charAt(i)+"")) ;
        	}
        }if(big.compareTo(new BigInteger("0")) == -1){
        	str = big + "" ;
        	for(int i=1; i<str.length(); i++){
        		stack.push(str.charAt(i)+"") ;
        	}
        	stack.push("-") ;
        }
        StringBuilder sb = new StringBuilder() ;
		while(!stack.isEmpty()){
			sb.append(stack.pop()) ;
		}
		int result = Integer.parseInt(sb.toString()) ;
		return result ;
    }
	
	public int reverse(int x) {
        long res = 0;
        for (; x != 0; x /= 10)
            res = res * 10 + x % 10;
        return res > Integer.MAX_VALUE || res < Integer.MIN_VALUE ? 0: (int) res;
    }
}
