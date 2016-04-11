package muyanmoyang.swadoffer;

import java.util.ArrayList;

/**
 * ����һ���������飬�жϸ������ǲ���ĳ�����������ĺ�������Ľ����
 * ����������Yes,�������No���������������������������ֶ�������ͬ��
 * @author hadoop
 *
 */
public class VerifySquenceOfBST {
	public static void main(String[] args) {
//		int test[] = {5,7,6,9,10,11,8} ;
		int test[] = {1,2,3,4,5} ;
		VerifySquenceOfBST v = new VerifySquenceOfBST() ;
		System.out.println(v.VerifySquenceOfBST(test)) ;
	}
	public boolean VerifySquenceOfBST(int [] sequence) {
		if(sequence==null || sequence.length==0){
			return false ;
		}
        int root = sequence[sequence.length - 1] ; //���ڵ�
        int index_left = 0;
        int index_right = 0;
        for(;index_left<sequence.length-1;index_left++){
        	if(sequence[index_left] > root){
        		break ;
        	}
        }
        index_right = index_left ;
        for(;index_right<sequence.length-1;index_right++){
        	if(sequence[index_right] < root){
        		return false ;
        	}
        }
        boolean left = true ;
        int[] seq_left = new int[index_left+1] ;
        int[] seq_right = new int[sequence.length-index_left] ;
        for(int i=0;i<index_left;i++){
        	seq_left[i] = sequence[i] ; //������
        }
        boolean right = true ;
        int count = 0 ;
        for(int i=index_right;i<sequence.length;i++){
        	seq_right[count] = sequence[i] ; //������
        	count ++ ;
        }
        // �ж��������Ƿ�������
        if(index_left > 0){
        	left = VerifySquenceOfBST(seq_left) ;
        }
        if(index_left > 0){
        	right = VerifySquenceOfBST(seq_right) ;
        }
		return (left && right) ;
    }
}
