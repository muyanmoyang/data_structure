package muyanmoyang.haffman;

public class HashTest {
	public static void main(String[] args) {
		System.out.println(hash("muyanmoyang")) ;
		System.out.println(hash("muyan")) ;
		System.out.println(hash("moyang")) ;
		System.out.println(hash("Obama")) ;
		System.out.println(hash("Oaamb")) ;
		
	}
	private static int hash(String str){
		int value = 0 ;
		char str1[] = str.toCharArray() ;
		for(int i=0; i<str1.length; i++){
			value = value + (int)str1[i];
		}
		return value % 1007 ;
	}
}
