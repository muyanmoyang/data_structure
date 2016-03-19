package muyanmoyang.swadoffer;

import javax.swing.text.html.MinimalHTMLWriter;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减序列的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * @author hadoop
 *
 */
public class findMinValueOfArray {
	
	public static void main(String[] args) {
		int array[] = {6,7,8,9,10,3,4,5} ;
		findMinValueOfArray f = new findMinValueOfArray() ;
		int min = f.minNumberInRotateArray(array) ;
		System.out.println("最小值：" + min) ;
	}
	public int minNumberInRotateArray(int [] array) {
		if(array == null || array.length == 0){
			return -1 ;
		}
		if(array.length==1){
            return array[0];
        }
	    int left = 0 ; 
	    int right = array.length - 1 ;
	    int mid = left ;
	    while(array[left] >= array[right]){
	    	if(right - left == 1){
	    		mid = right ;
	    		break ;
	    	}
	    	mid = (left + right)/2 ; 
	    	if(array[mid] >= array[left]){
	    		left = mid ;
	    	}else if(array[mid] <= array[right]){
	    		right = mid ;
	    	}
	    }
	    return array[mid] ;
    }
}
