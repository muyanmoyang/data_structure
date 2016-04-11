package muyanmoyang.leetcode;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Hint: Carefully consider all possible input cases. 
 * @author hadoop
 *
 */
public class MyAtoi_8 {
	public static void main(String[] args) {
		String str = "+12dw422";
		MyAtoi_8 m = new MyAtoi_8() ;
		System.out.println(m.myAtoi(str)) ;
	}
	public int myAtoi(String str) {
		String data = str.trim() ;
		String new_data = ""  ;
		for(int i=0; i<data.length(); i++){
			if(data.charAt(i) == '+' || data.charAt(i) == '-' || (data.charAt(i)>='0' && data.charAt(i)<='9'))
				new_data += (data.charAt(i) + "") ;
			else{
				break ;
			}
		}
		Pattern pattern = Pattern.compile("^[+-[0-9]][0-9]*$");
		Matcher matcher = pattern.matcher(new_data);
//		System.out.println(matcher.find()) ;
		if(new_data==null || new_data.length()==0 || !matcher.find()){
			System.out.println("invalid...") ;
			return 0 ;
		}
		boolean flag = true ;
		int len = 0 ;
		int start ;
		if(new_data.startsWith("-") || new_data.startsWith("+")){
			flag = false ;
			len = new_data.length() - 1 ;
			start = 1 ;
		}else{
			len = new_data.length() ;
			start = 0 ;
		}
		
		char[] character = new_data.toCharArray() ;
		int sum = 0 ;
		int temp ;
		for(; start<character.length; start++){
			if(new_data.startsWith("-") || new_data.startsWith("+")){
				temp = character[start] - '0' ;
				if(new_data.startsWith("-"))
					sum += (-1) * temp * Math.pow(10,len-start) ;
				else
					sum += temp * Math.pow(10,len-start) ;
			}else{
				temp = character[start] - '0' ;
				sum += temp * Math.pow(10,len-start-1) ;
			}
		}
		return sum;
    } 
}
