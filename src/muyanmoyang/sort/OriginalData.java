package muyanmoyang.sort;

import java.util.ArrayList;
import java.util.List;

/*
 *  生成排序所需的待排序数据
 */
public class OriginalData {
	 public static void main(String[] args) {
		int[] data = generateData();
		show(data) ;
 	}

	public static void show(int[] data) {
		// TODO Auto-generated method stub
		for(int i=0; i<data.length; i++){
			System.out.print(data[i] + "、"); 
		}
		System.out.println();
	}

	public static int[] generateData() {
		int[] data = new int[10] ;
		for(int i=0; i<10; i++){
			data[i] = (int) (Math.random()*100) ;
		}
		return data ;
	}
	
	public static void swap(int[] data ,int a, int b){
		int tmp = data[a] ;
		data[a] = data[b] ;
		data[b] = tmp ;
	}
}
