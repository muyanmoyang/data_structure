package muyanmoyang.java;

import java.util.ArrayList;


public class JavaDemo1 {
	public static void main(String[] args) {
		compare_Str();
		ArrayList list = new ArrayList<>() ;
		System.out.println("test...")
	}

	private static void compare_Str() {
		String s1 = new String("we") ;
		String s2 = new String("we") ;
		StringBuffer sb1 = new StringBuffer("dew") ;
		StringBuffer sb2 = new StringBuffer("dew") ;
		StringBuffer s3 = new StringBuffer("we") ;
		System.out.println(s1.equals(s2) + "\t" + (s1==s2));
		System.out.println(sb1.equals(sb2) + "\t" + (sb1==sb2));
		System.out.println(sb1.hashCode() +"//////" + sb2.hashCode());  // 返回的是对象的地址值
		System.out.println(s1.hashCode() + "//////" + s2.hashCode());  // String类对hashcode进行了覆写，比较的是字符串的hash值
		System.out.println(s3.hashCode());
	}
}
