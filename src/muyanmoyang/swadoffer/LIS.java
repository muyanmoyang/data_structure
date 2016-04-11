package muyanmoyang.swadoffer;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *  LIS���⣺�������������
 * @author hadoop
 *
 */
public class LIS {
	public static void main(String[] args) throws InterruptedException {
		int[] array = {154,65,76,9,8790,8,54,6,7,68,79,60,9} ;
		LIS(array); 
	}
	public static void LIS(int[] array) throws InterruptedException{
		// ��ԭ������п�������
		int[] originalArray = new int[array.length] ;
		for(int i=0; i<array.length; i++){
			originalArray[i] = array[i] ;
		}
		System.out.println("---------------ԭ����----------------") ;
		for(int elem : originalArray){
			System.out.print(elem + "��");
		}
		System.out.println("\n---------------���������----------------") ;
		quickSort(array,0,array.length-1) ;
		for(int elem : array){
			System.out.print(elem + "��");
		}
		System.out.println("\n---------------�����������----------------") ;
		List<Integer> result = LCS(originalArray, array) ;  // LCS
		Stack<Integer> stack = new Stack<Integer>() ;
		for(int elem : result){
			stack.push(elem) ;
		}
		while(!stack.isEmpty()){
			System.out.print(stack.pop() + "��") ;
		}
	}
	/*
	 *   LCS
	 */
	private static List<Integer> LCS(int[] originalArray, int[] array) { 
		int[][] matrix_lcs = new int[originalArray.length + 1][array.length + 1];
		int[] ch1 = originalArray;
		int[] ch2 = array;
		int sum = 0;
		for (int i = 0; i <= ch1.length; i++) {
			for (int j = 0; j <= ch2.length; j++) {
				if (i == 0 || j == 0) {
					matrix_lcs[i][j] = 0;
				} else if (ch1[i-1] == ch2[j-1]) {
					matrix_lcs[i][j] = matrix_lcs[i - 1][j - 1] + 1;
				} else {
					if (matrix_lcs[i][j - 1] < matrix_lcs[i - 1][j]) {
						matrix_lcs[i][j] = matrix_lcs[i - 1][j];
					} else {
						matrix_lcs[i][j] = matrix_lcs[i][j - 1];
					}
				}
			}
		}
		/*
		 * ��ӡ��ά����
		 */
//		for (int i = 0; i < matrix_lcs.length; i++) {
//			for (int j = 0; j < matrix_lcs[i].length; j++) {
//				System.out.print(matrix_lcs[i][j] + " ");
//			}
//			System.out.println();
//		}
		/*
		 * �Ӷ�ά�������ҳ�LCS
		 */
		List<Integer> list = new ArrayList<Integer>() ;
		int i = matrix_lcs.length - 1;
		int j = matrix_lcs[0].length - 1;
//		System.out.println("i=" + i + "///// j=" + j) ;
		for (;j >= 1 && i >= 1;) {
//			System.out.println(ch1[i-1] + " : " + ch2[j-1]) ;
//			Thread.sleep(1000) ;
			if (ch1[i-1] == ch2[j-1]) {
				list.add(ch1[i-1]);
				i -- ;
				j -- ;
			} else{
				if (matrix_lcs[i][j-1] > matrix_lcs[i-1][j]){
					j--;
				}
//				if(matrix_lcs[i][j-1] == matrix_lcs[i-1][j]){
//					j -- ;
//				}
				else{
					i--;
				}
			}
		}
		return list ;
	}
	
	/*
	 *  ����
	 */
	private static void quickSort(int[] array, int l, int r) {
		int i = l ; 
		int j = r ;
		int temp ;
		if(l < r){
			temp = array[l] ;
			while(i != j){
				while(j > i && array[j] > temp){
					j -- ;
				}
				if(i < j){
					array[i] = array[j] ;
					i ++ ;
				}
				while(i < j && array[i] < temp){
					i ++ ;
				}
				if(i < j){
					array[j] = array[i] ;
					j -- ;
				}
			}
			array[i] = temp ;
			quickSort(array, l, i-1);
			quickSort(array, i+1, r);
		}
	}
}
