package muyanmoyang.swadoffer;

import java.util.Stack;

import org.omg.CORBA.PRIVATE_MEMBER;

/**
 * �����ӡ����
 * @author hadoop
 *
 */

public class PrintListWithReverse {
	
	public static ListNode head ; // ͷ�ڵ�
	public int pos = 0; //�ڵ��λ��
	public static void main(String[] args) {
		PrintListWithReverse plr = new PrintListWithReverse() ;
		plr.addFirstNode("H");
		plr.add(1, "K");
		plr.add(2, "C");
		plr.reverseListPrint(head);  // ջʵ�ַ����ӡ
		plr.reversePrintRecursive(head); // �ݹ�ʵ�ַ����ӡ
	}
	
	  // ����һ��ͷ�ڵ�  
    public void addFirstNode( String data) {  
         ListNode node = new ListNode(data);  
         node. next = head;  
         head = node;  
    }  
    /*
     *  ������λ�ò���ڵ�
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
	 *  ʹ��ջʵ�� �����ӡ���Ƽ���
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
	 *  ʹ�õݹ�ʵ�� �����ӡ  (ȱ�㣺�ݹ���ò㼶����)
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
