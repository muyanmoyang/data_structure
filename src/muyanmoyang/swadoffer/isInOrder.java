package muyanmoyang.swadoffer;

import java.util.Stack;

/**
 *   判断某个序列是否是某个入栈序列的弹出序列 
 */
public class isInOrder {
	public static void main(String[] args) {
		int[] pushA = {1,2,3,4,5} ;
		int[] popA = {4,5,3,2,1} ;
		isInOrder isIn = new isInOrder() ;
		System.out.println(isIn.IsPopOrder(pushA, popA)) ;
	}
	public boolean IsPopOrder(int [] pushA,int [] popA) {
		Stack<Integer> stack = new Stack<Integer>() ; // 辅助栈
		if(pushA==null || pushA.length==0){
			return false ;
		}
		int push_index = 0 ;
		int pop_index = 0 ;
		stack.push(pushA[0]) ;
		for(int i=0; i<popA.length; i++){
			while(popA[i]!=stack.peek()){
				push_index ++ ;
				if(push_index >= pushA.length){
					return false ;
				}
				stack.push(pushA[push_index]) ;
			}
			stack.pop() ;
		}
		return true ;
	}
}
