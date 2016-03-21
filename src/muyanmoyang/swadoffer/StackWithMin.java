package muyanmoyang.swadoffer;

import java.util.Stack;


/**
 * ����min������ջ
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
		stackWithMin.pop(); // ����ջ�Ĳ�����СԪ��
		System.out.println(stackWithMin.min());   // ----> 3
		stackWithMin.pop();
		stackWithMin.pop(); // ����ջ������СԪ��     
		System.out.println(stackWithMin.min());   // ----> 34
	}
	/*
	 * ѹջ
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
	 *  ��ջ
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
