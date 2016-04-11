package muyanmoyang.java;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.TreeMap;

public class HashTest {
	public static void main(String[] args) {
		Object key = 100 ;
		int h ;
		h = key.hashCode() ;
		h = h ^ (h >>> 16) ;
		System.out.println(h);
		
		
		int a = 10 ;
		int b = a >>> 16 ;
		System.out.println("b=" + b) ;
		
		
		LinkedHashMap<Integer,String> map = new LinkedHashMap<Integer,String>() ;
		map.put(1, "myan") ;
		map.put(2, "koan") ;
		map.put(3, "aoan") ;
		Collection<String> value = map.values() ;
		System.out.println(value);
		
		TreeMap<Integer,String> map2 = new TreeMap<Integer,String>() ;
		map2.put(1, "muyan") ;
		map2.put(2, "freag") ;
		map2.put(10, "ADEAGFR") ;
		map2.put(4, "rthytj") ;
		System.out.println(map2.values()) ;
	}
}
