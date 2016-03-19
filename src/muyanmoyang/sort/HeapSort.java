package muyanmoyang.sort;

import java.util.Arrays;
/**
 *  堆排序
 * @author hadoop
 *
 */
public class HeapSort {
	public static void main(String[] args) {
		int[] data = OriginalData.generateData() ;
		OriginalData.show(data);
		heapSort(data) ;
		OriginalData.show(data); 
	}
	private static void heapSort(int[] data) {
		for(int i=0;i<data.length-1;i++){ 
			//建堆  
			buildHeap(data,data.length-1-i); 
			//交换堆顶和最后一个元素  
			OriginalData.swap(data,0,data.length-1-i);  
			System.out.println(Arrays.toString(data));
		}
	}
	private static void buildHeap(int[] data , int lastIndex) {
		for(int i=(lastIndex-1)/2; i>=0; i--){   // 从最后一个节点的父节点开始
			int k = i ;                 // 该节点设为k
			while(k*2+1 <= lastIndex){     // k的左孩子存在
				int biggerIndex = k * 2 + 1 ;   // 当前节点的左孩子序号
				if(biggerIndex < lastIndex){
					if(data[biggerIndex] < data[biggerIndex+1]){
						biggerIndex ++ ;   // 当前节点右孩子节点
					}
				}
				if(data[k] < data[biggerIndex]){  // 如果当前节点比其右孩子小，则交换
					OriginalData.swap(data, k, biggerIndex) ;
					k = lastIndex ;
				}else{
					break ;
				}
			}
		}
	}
}




