package muyanmoyang.sort;

import java.util.Arrays;
/**
 *  ������
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
			//����  
			buildHeap(data,data.length-1-i); 
			//�����Ѷ������һ��Ԫ��  
			OriginalData.swap(data,0,data.length-1-i);  
			System.out.println(Arrays.toString(data));
		}
	}
	private static void buildHeap(int[] data , int lastIndex) {
		for(int i=(lastIndex-1)/2; i>=0; i--){   // �����һ���ڵ�ĸ��ڵ㿪ʼ
			int k = i ;                 // �ýڵ���Ϊk
			while(k*2+1 <= lastIndex){     // k�����Ӵ���
				int biggerIndex = k * 2 + 1 ;   // ��ǰ�ڵ���������
				if(biggerIndex < lastIndex){
					if(data[biggerIndex] < data[biggerIndex+1]){
						biggerIndex ++ ;   // ��ǰ�ڵ��Һ��ӽڵ�
					}
				}
				if(data[k] < data[biggerIndex]){  // �����ǰ�ڵ�����Һ���С���򽻻�
					OriginalData.swap(data, k, biggerIndex) ;
					k = lastIndex ;
				}else{
					break ;
				}
			}
		}
	}
}




