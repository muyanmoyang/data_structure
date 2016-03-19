package muyanmoyang.sort;

import java.util.List;

/**
 * √∞≈›≈≈–Ú
 * @author hadoop
 *
 */
public class BubbleSort {
	public static void main(String[] args) {
		int[] data = OriginalData.generateData() ;
		OriginalData.show(data);
		
		long start = System.currentTimeMillis() ;
		bubbleSort(data) ;
		long end  = System.currentTimeMillis() ;
		System.out.println("√∞≈›≈≈–Ú£∫" + (end - start) + "ms");
		OriginalData.show(data); 
	}
	
	/**
	 * √∞≈›≈≈–Ú
	 */
	private static void bubbleSort(int[] data) {
		for(int i=0; i<data.length; i++){
			for(int j=0; j<data.length-i-1; j++){
				if(data[j] > data[j+1]){
					OriginalData.swap(data, j,j+1);
				}
			}
		}
	}
	private static void bubbleSort_adv(int[] data) {
		boolean flag = true ;
		for(int i=0; i<data.length && flag; i++){
			flag = false ;
			for(int j=0; j<data.length-i-1; j++){
				if(data[j] > data[j+1]){
					OriginalData.swap(data, j,j+1);
					flag = true ;
				}
			}
		}
	}
	
}
