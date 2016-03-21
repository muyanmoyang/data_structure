package muyanmoyang.swadoffer;

import java.util.ArrayList;

/**
 *  ˳ʱ���ӡ��ά����
 * @author hadoop
 *
 */
public class PrintArrayClock {
	public static void main(String[] args) {
		PrintArrayClock p = new PrintArrayClock() ;
		int[][] matrix = {{1,3,4},{4,5,6},{7,8,9}} ;
		ArrayList<Integer> list = p.printMatrix(matrix) ;
		for(int elem : list){
			System.out.print(elem + "��") ;
		}
	}
	
	ArrayList<Integer> list = new ArrayList<Integer>() ;
	public ArrayList<Integer> printMatrix(int [][] matrix) {
	    if(matrix == null){
	    	return null ;
	    }
		int columns = matrix[0].length ; //��
		int rows = matrix.length ; //��
	    ArrayList<Integer> list = new ArrayList<Integer>() ;
		int start = 0 ;
		while(columns > start * 2 && rows > start * 2){
			list = PrintMatrixInCircle(matrix, columns, rows, start) ;
			start ++ ;
		}
		return list ;
    }
	/*
	 *  ��ӡÿһȦ
	 */
	private ArrayList<Integer> PrintMatrixInCircle(int[][] matrix, int columns, int rows,int start) {
		int endX = columns - 1 - start ;
		int endY = rows - 1 - start ;
		int number = 0 ;
		// 1
		for(int i=start; i<=endX; i++){
			list.add(matrix[start][i]) ;
 		}
		// 2 
		if(start < endY){
			for(int i=start+1; i<=endY; i++){
				list.add(matrix[i][endX]) ;
			}
		}
		// 3
		if(start<endX &&  start <  endY){
			for(int i=endX-1; i>=start; i--){
				list.add(number = matrix[endY][i]) ;
			}
		}
		// 4
		if(start<endX && start<endY-1){
			for(int i=endY-1; i>=start+1; i--){
				list.add(number = matrix[i][start]) ;
			}
		}
		return list ;
	}
}
