package muyanmoyang.swadoffer;

import javax.swing.text.html.MinimalHTMLWriter;

/**
 * ��һ�������ʼ�����ɸ�Ԫ�ذᵽ�����ĩβ�����ǳ�֮Ϊ�������ת��
 * ����һ���ǵݼ����е�һ����ת�������ת�������СԪ�ء�
 * ��������{3,4,5,1,2}Ϊ{1,2,3,4,5}��һ����ת�����������СֵΪ1��
 * @author hadoop
 *
 */
public class findMinValueOfArray {
	
	public static void main(String[] args) {
		int array[] = {6,7,8,9,10,3,4,5} ;
		findMinValueOfArray f = new findMinValueOfArray() ;
		int min = f.minNumberInRotateArray(array) ;
		System.out.println("��Сֵ��" + min) ;
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
