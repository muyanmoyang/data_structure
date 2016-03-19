package muyanmoyang.swadoffer;

import java.util.Stack;

import org.omg.CORBA.PRIVATE_MEMBER;

/**
 * 反向打印链表
 * @author hadoop
 *
 */

public class PrintListWithReverse {
	
	public static ListNode head ; // 头节点
	public int pos = 0; //节点的位置
	public static void main(String[] args) {
		PrintListWithReverse plr = new PrintListWithReverse() ;
		plr.addFirstNode("H");
		plr.add(1, "K");
		plr.add(2, "C");
		plr.reverseListPrint(head);  // 栈实现反向打印
		plr.reversePrintRecursive(head); // 递归实现反向打印
	}
	
	  // 插入一个头节点  
    public void addFirstNode( String data) {  
         ListNode node = new ListNode(data);  
         node. next = head;  
         head = node;  
    }  
    /*
     *  在任意位置插入节点
     */
    public void add(int index, String data){
    	ListNode node = new ListNode(data) ;
    	ListNode current  = head ;
    	ListNode previous  = head ;
    	while(pos != index){
    		previous = current ;
    		current = current.next ;
    		pos ++ ;
    	}
    	node.next = current ;
    	previous.next = node ;
    	pos = 0 ;
    }
	
	/*
	 *  使用栈实现 反向打印（推荐）
	 */
	public void reverseListPrint(ListNode list){
		Stack<ListNode> stack = new Stack<ListNode>() ;
		ListNode ln = list;
		while(ln != null){
			stack.push(ln) ;
			ln = ln.next ;
		}
		System.out.println(stack.size()) ;
		while(!stack.isEmpty()){
			ListNode node = stack.pop() ;
			System.out.println(node.getData());
		}
	}
	
	/*
	 *  使用递归实现 反向打印  (缺点：递归调用层级过深)
	 */
	public void reversePrintRecursive(ListNode list){
		ListNode ln = list;
		if(ln != null){
			if(ln.next != null){
				reversePrintRecursive(ln.next);
			}
			System.out.println(ln.getData()); 
		}
	}
}

class ListNode {
	public String data ;
	public ListNode next ;
	
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public ListNode getNext() {
		return next;
	}
	public void setNext(ListNode next) {
		this.next = next;
	}
	
	public ListNode(String data) {
		super();
		this.data = data;
	}
	public ListNode(String data, ListNode next) {
		super();
		this.data = data;
		this.next = next;
	}
}
