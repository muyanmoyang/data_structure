package muyanmoyang.leetcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 	Given an integer, convert it to a roman numeral.
	Input is guaranteed to be within the range from 1 to 3999.
 * @author hadoop
 *
 */
public class IntToRoman_12 {
	public static void main(String[] args) {
		IntToRoman_12 i = new IntToRoman_12() ;
		System.out.println("result=" + i.intToRoman(40)) ;
	}
	public static String intToRoman(int num) {
        String M[] = {"", "M", "MM", "MMM"}; // 1000 - 3000
        String C[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"}; // 100 - 900
        String X[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"}; // 10 - 90
        String I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"}; // 1 - 9
        return M[num/1000] + C[(num%1000)/100] + X[(num%100)/10] + I[num%10];
    }
/*
	public String intToRoman(int num) {
		Map<Integer,String> map = new LinkedHashMap<Integer,String>() ;
		String[] smallNum = {"I","II","III","IV","V","VI","VII","VIII","IX"};
		map.put(10,"X") ;
		map.put(50,"L") ;
		map.put(100,"C") ;
		map.put(500,"D") ;
		map.put(1000,"M") ;
		List<String> result = new ArrayList<String>() ;
		int len = (num + "").length() ;
		System.out.println("len=" + len);
		if(num >=10){
			for(int i=len-1; i>0; i--){
				int mod = (int) (num % (Math.pow(10,i))) ;
				System.out.println("mod=" + mod);
				Entry<Integer,String> entry = null ;
				ListIterator<Map.Entry<Integer,String>> tmp = new ArrayList<Map.Entry<Integer,String>>(map.entrySet())
							.listIterator(map.size());
				
				while(tmp.hasPrevious()){
					entry = tmp.previous() ;
					if(num < entry.getKey())
						continue ;
					else
						break ;
				} 
				
				int index = num / (entry.getKey()) ; //需要添加几个M,D,C,L,X?
				System.out.println("entry.getKey = " + entry.getKey()) ; 
				System.out.println("index=" + index);
				for(int m=0; m<index; m++){
					result.add(entry.getValue()) ;
				}
				num = mod ;
			}
		}
		System.out.println("num=" + num);
		if(num < 10 && num > 0){
			result.add(smallNum[num-1]) ;
		}
		StringBuilder sb = new StringBuilder() ;
		for(String elem : result){
			sb.append(elem) ;
		}
		return sb.toString() ;
    }
*/
}
