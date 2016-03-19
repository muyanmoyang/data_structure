package muyanmoyang.swadoffer;

import java.util.Stack;

/**
 *  双栈实现队列
 * @author hadoop
 *
 */
public class ConstructQueueWith2Stack {
	
	Stack<Integer> stack1 = new Stack<Integer>();
	Stack<Integer> stack2 = new Stack<Integer>();
	public void push(int node) {
		stack1.push(node) ;
	}
	    
	public int pop(){
		if(stack2.isEmpty()){
			while(!stack1.isEmpty()){
				int node = stack1.pop() ;
				stack2.push(node) ;
			}
		}
		return stack2.pop();
	}
	
	public static void main(String[] args) {
		ConstructQueueWith2Stack s = new ConstructQueueWith2Stack() ;
		s.push(124);
		s.push(1154);
		s.push(45);
		s.push(75);
		s.push(157);
		for(int i=0; i<5; i++){
			System.out.print(s.pop() + "、") ;
		}
	}
}
