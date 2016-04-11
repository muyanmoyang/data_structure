package muyanmoyang.leetcode;

/**
 *  Determine whether an integer is a palindrome. Do this without extra space.
 * @author hadoop
 *
 */
public class IsPalindrome_9 {
	public static void main(String[] args) {
		IsPalindrome_9 i = new IsPalindrome_9() ;
		System.out.println(i.isPalindrome(2047447402)) ;
		System.out.println(Integer.toBinaryString(101)) ;
		
	}
	
	public boolean isPalindrome(int x) {
		if(x < 0){
			return false ;
		}
		int reverse = reverse(x) ;
		if(reverse == x){
			return true ;
		}else{
			return false ;
		}
    }
	private int reverse(int x) {
		int i = 0;
		int j = 0 ;
		i = x ;
		while(i!=0){
			j = j * 10 + i % 10 ;
			i = i / 10 ;
		}
		return j ;
	}
}
