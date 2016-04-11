package muyanmoyang.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given a string, find the length of the longest substring without repeating characters. 
 * For example, the longest substring without repeating letters for "abcabcbb" is "abc", 
 * which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
 * @author hadoop
 *
 */
public class LengthOfLongestSubstring_3 {
	public static void main(String[] args) {
		LengthOfLongestSubstring_3 l = new LengthOfLongestSubstring_3() ;
		System.out.println(l.lengthOfLongestSubstring("abccedeefgh")) ;
	}
	public int lengthOfLongestSubstring(String s) {
		if(s.length() == 0){
			return 0 ;
		}
		Set set = null;
		List<Integer> result = null ;
		result = new ArrayList<Integer>() ;
		for(int j=0; j<s.length(); j++){
			int count = 0 ;
			set = new HashSet() ;
//			System.out.println("-------------") ;
			for(int i=j; i<s.length(); i++){
				if(!set.contains(s.charAt(i))){
					set.add(s.charAt(i)) ;
					count ++ ;
					if(i==s.length()-1){
						result.add(count) ;
						break ;
					}
				}else{
					result.add(count) ;
//					System.out.println(result.size());
					break ;
				}
			}
		}
//		System.out.println(result.size()) ;
//		for(int elem : result){
//			System.out.print(elem + "¡¢");
//		}
		int max = Integer.MIN_VALUE ;
		for(int elem : result){
			if(elem > max){
				max = elem ;
			}
		}
		return max ;
    }
}
