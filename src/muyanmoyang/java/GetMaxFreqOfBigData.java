package muyanmoyang.java;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * �ں����������ҳ����ִ�������һ��
 * 
 * @author hadoop
 * 
 */
public class GetMaxFreqOfBigData {
	public static void main(String[] args) throws IOException {
		hashFun();
		getMaxFreq();
	}

	public static void hashFun() throws IOException {
		InputStreamReader reader = new InputStreamReader(new FileInputStream(
				new File("C:/Users/Administrator/Desktop/Job/��Ŀ/topData.txt")),
				"utf-8");
		FileWriter writer;
		BufferedWriter bw = null;

		BufferedReader BR = new BufferedReader(reader);
		Map<String, Integer> map = new HashMap<String, Integer>();
		String line;
		while ((line = BR.readLine()) != null) {
			String str[] = line.split("\t");
			int hash = str[0].hashCode() % 100;
			// System.out.println(str[0]) ;
			writer = new FileWriter(new File(
					"C:/Users/Administrator/Desktop/Job/��Ŀ/bigdata/file_"
							+ hash + ".txt"), true);
			bw = new BufferedWriter(writer);
			bw.write(str[0] + "\n");
			bw.flush();
		}
		bw.close();
	}

	/*
	 * ͳ��ÿ��С�ļ��г���Ƶ����ߵ�һ��
	 */
	public static LinkedList<Entry<String,Integer>> statisticMaxOfOneTxt()
			throws IOException {
		InputStreamReader reader;
		BufferedReader BR ;
		Map<String,Integer> map ;
		LinkedList<Entry<String,Integer>> result = new LinkedList<Entry<String,Integer>>() ;
		File[] tempList = new File(
				"C:/Users/Administrator/Desktop/Job/��Ŀ/bigdata/").listFiles();
		for (File file : tempList) {
			map = new HashMap<String,Integer>() ;
			if (file.isFile()) {
				reader = new InputStreamReader(new FileInputStream(file),"utf-8");
				BR = new BufferedReader(reader) ;
				String line ;
				while((line = BR.readLine()) != null){
					if(map.containsKey(line)){ 
						map.put(line,map.get(line)+1) ;
					}else{
						map.put(line, 1) ;
					}
				}
			}
			// ��map��value����
			List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String,Integer>>(map.entrySet()); 
			Collections.sort(list,new Comparator<Map.Entry<String, Integer>>() {  
				@Override  
				public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {  
					return (o2.getValue() - o1.getValue());  
				}  
			});
			result.add(list.get(0)) ;
		}
		return result ;
	}
	/*
	 *  ȡ�ó��ִ�������
	 */
	public static void getMaxFreq() throws IOException {
		LinkedList<Entry<String,Integer>> list = statisticMaxOfOneTxt() ;
		int[] max = new int[1] ;
		max[0] = Integer.MIN_VALUE ;
		int index = 0 ;
		for(int i=0; i<list.size(); i++){
			if(max[0] < list.get(i).getValue()){
				max[0] = list.get(i).getValue() ;
				index = i ;
			}
		}
		System.out.println("�ظ����������ǣ�"+list.get(index).getKey()+"   ���ֵĴ����ǣ�"+list.get(index).getValue());
	}
}
