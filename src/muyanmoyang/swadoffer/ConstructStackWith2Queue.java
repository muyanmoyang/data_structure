package muyanmoyang.swadoffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 *  双队列实现栈
 * @author hadoop
 *
 */
public class ConstructStackWith2Queue {
	
	Queue<Integer> queue1 = new LinkedList<Integer>() ;
	Queue<Integer> queue2 = new LinkedList<Integer>() ;
	
	public void push(int node) {
		queue1.add(node) ;
	}
	    
//	public int pop(){
//		Queue<Integer> tmp1 = null ,tmp2 = null;
//		if(queue2.isEmpty()){
//			tmp2 = queue2 ;
//			tmp1 = queue1 ;
//		}
//		if(queue1.isEmpty()){
//			tmp2 = queue1 ;
//			tmp1 = queue2 ;
//		}
//		int size = tmp1.size() ; // 第一个队列的大小
//		if(tmp2.isEmpty()){
//			for(int i=0;i<size-1; i++){
//				int node = tmp1.poll() ;
//				tmp2.add(node);
//			}
//		}
//		return tmp1.poll() ;
//	}
	
	public int pop2(){
		if(queue1.isEmpty()){
			return popFun(queue2,queue1);
		}else{
			return popFun(queue1,queue2);
		}
	}

	private int popFun(Queue a, Queue b) {
		int size = a.size() ; // 第一个队列的大小
		if(b.isEmpty()){
			for(int i=0;i<size-1; i++){
				int node = (int) a.poll() ;
				b.add(node);
			}
		}
		return (int) a.poll() ;
	}
	
	
	public static void main(String[] args) {
		ConstructStackWith2Queue s = new ConstructStackWith2Queue() ;
		List<Integer> list = new ArrayList<Integer>() ;
		for(int i=0; i<10; i++){
			int tmp = (int) (Math.random() * 1000) ;
			s.push(tmp);
			list.add(tmp) ;
		}
		System.out.print("进栈————>：");
		for(int elem : list){
			System.out.print(elem + "、");
		}
		System.out.print("\n出栈————>：");
		for(int i=0; i<list.size(); i++){
			System.out.print(s.pop2() + "、") ;
		}
	}
}
