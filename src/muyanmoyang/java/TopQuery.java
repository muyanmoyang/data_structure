package muyanmoyang.java;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class TopQuery {
	
	public static void main(String[] args) throws IOException {
		sortQuery();
	}
	/*
	 *  统计query< 查询 ： 次数>
	 */
	public static Map<String,Integer> query() throws IOException{
		InputStreamReader reader = new InputStreamReader(
				new FileInputStream(new File("C:/Users/Administrator/Desktop/Job/项目/topData.txt")),"utf-8") ;
		BufferedReader BR = new BufferedReader(reader) ;
		Map<String,Integer> map = new HashMap<String,Integer>() ;
		String line ; 
		while((line=BR.readLine()) != null){ 
			String[] str = line.split("\t") ;
			if(str.length < 3){
				continue ;
			}
//			System.out.println(str.length) ;
			if(map.containsKey(str[2])){
				map.put(str[2],map.get(str[2])+1) ;
			}else{
				map.put(str[2], 1) ;
			}
		}
//		System.out.println("map的大小：" + map.size()) ;
		return map ;
	}
	
	/*
	 *  对query出现次数进行排序
	 */
	public static void sortQuery() throws IOException{
		int top = 10 ;
		Map<String,Integer> map = query();
		List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String,Integer>>(map.entrySet()); 
		Collections.sort(list,new Comparator<Map.Entry<String, Integer>>() {  
			@Override  
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {  
				return (o2.getValue() - o1.getValue());  
			}  
		});
		
		for(int i=0; i<top; i++){
			Entry<String, Integer> entry = list.get(i) ;
			System.out.println("查询字段：" + entry.getKey() + "     频率：" + entry.getValue()) ; 
		}
	}
}
