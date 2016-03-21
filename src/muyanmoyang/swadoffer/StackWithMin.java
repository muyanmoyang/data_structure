package muyanmoyang.swadoffer;

import java.util.Stack;


/**
 * 包含min函数的栈
 * 
 * @author hadoop
 * 
 */
public class StackWithMin {
	public static void main(String[] args) {
		StackWithMin stackWithMin = new StackWithMin() ;
		stackWithMin.push(124);
		stackWithMin.push(34);
		stackWithMin.push(432);
		stackWithMin.push(76);
		stackWithMin.push(3);
		stackWithMin.push(12);
		stackWithMin.push(100);
//		for(int i=0; i<4; i++){
//			System.out.println(stackWithMin.top()) ;
//			stackWithMin.pop(); 
//		}
		System.out.println(stackWithMin.min());
		stackWithMin.pop(); // 弹出栈的不是最小元素
		System.out.println(stackWithMin.min());   // ----> 3
		stackWithMin.pop();
		stackWithMin.pop(); // 弹出栈的是最小元素     
		System.out.println(stackWithMin.min());   // ----> 34
	}
	/*
	 * 压栈
	 */
	Stack<Integer> originalSatck = new Stack<Integer>() ;
	Stack<Integer> minStack = new Stack<Integer>() ;
	public void push(int node) {
		
		originalSatck.push(node) ;
		if(minStack.size()==0 || node < minStack.peek()){
			minStack.push(node) ;
		}else{
			minStack.push(minStack.peek()) ;
		}
	}	
	/*
	 *  出栈
	 */
	public void pop() {
		
		if(originalSatck.size()>0 && minStack.size()>0){
			originalSatck.pop() ;
			minStack.pop() ;
		}
	}

	public int top() {
		return originalSatck.peek();
	}

	public int min() {
		if(originalSatck.size()>0 && minStack.size()>0){
			return minStack.peek() ;
		}else{
			return 0 ;
		}
	}
}
