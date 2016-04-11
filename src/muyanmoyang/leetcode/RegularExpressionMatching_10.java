package muyanmoyang.leetcode;

import java.util.Arrays;

/**
 * Implement regular expression matching with support for '.' and '*'.
 * 
 * @author hadoop
 * 
 *         isMatch("aa","a") �� false isMatch("aa","aa") �� true
 *         isMatch("aaa","aa") �� false isMatch("aa", "a*") �� true isMatch("aa",
 *         ".*") �� true isMatch("ab", ".*") �� true isMatch("aab", "c*a*b") ��
 *         true
 * 
 */
public class RegularExpressionMatching_10 {
	public static void main(String[] args) {
		RegularExpressionMatching_10 r = new RegularExpressionMatching_10();
		System.out.println(r.isMatch("aaa", "a*aaa"));
	}

	public boolean isMatch(String s, String p) {
	    boolean[] match = new boolean[s.length()+1];
	    Arrays.fill(match, false);
	    match[s.length()] = true;
	    for(int i=p.length()-1 ; i>=0 ; i--){
	    	if(p.charAt(i) == '*'){
	    		for(int j = s.length()-1; j>=0 ; j--){
	            	match[j] = match[j] || match[j+1] && (p.charAt(i-1)=='.'||s.charAt(j)==p.charAt(i-1));
	            }
	            i--;
	        }
	        else{
	            for(int j=0;j<s.length();j++){
	            	match[j] = match[j+1] && (p.charAt(i)=='.' || p.charAt(i)==s.charAt(j));
	            }
	            match[s.length()] = false;
	        }
	    }
	    return match[0];
	}
}
