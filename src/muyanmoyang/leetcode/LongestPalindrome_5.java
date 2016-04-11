package muyanmoyang.leetcode;

/**
 *  Given a string S, find the longest palindromic substring in S. You may assume that the maximum length of S is 1000, 
 *  and there exists one unique longest palindromic substring.
 * @author Ray Chase
 * 
 */
public class LongestPalindrome_5 {
	public static void main(String[] args) {
		LongestPalindrome_5 l = new LongestPalindrome_5();
		System.out.println(l.longestPalindrome("civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcan"
				+ "longendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestin"
				+ "gplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisBu"
				+ "tinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwh"
				+ "ostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongr"
				+ "ememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheu"
				+ "lnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegr"
				+ "eattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygave"
				+ "thelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnation"
				+ "unsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishf"
				+ "romtheearth"));
	}
	
	public String longestPalindrome(String s) {
		// boolean P[][]= new boolean[s.length()][s.length()] ;
		int n = s.length();
		int longestBegin = 0;
		int maxLen = 1;
		boolean table[][] = new boolean[s.length()][s.length()];
		for (int i = 0; i < n; i++) {
			table[i][i] = true;
		}
		for(int i=0; i<n-1; i++){
			if(s.charAt(i) == s.charAt(i++)){
				table[i][i+1] = true ;
				longestBegin = i ;
				maxLen = 2 ;
			}
		}
		for(int len=3; len<=n; len++){
			for(int i=0; i<n-len+1; i++){
				int j = i + len - 1;
				if(s.charAt(i) == s.charAt(j) && table[i+1][j-1]){
					table[i][j] = true;
					longestBegin = i ;
					maxLen = len ;
				}
			}
		}
		System.out.println("longestBegin = " + longestBegin + "      maxLen = " + maxLen) ;
		return s.substring(longestBegin, longestBegin+maxLen);
	}
}
