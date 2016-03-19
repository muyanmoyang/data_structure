package muyanmoyang.data_structure.List_2;

public class ListOperation {
	
	public ListNode head = null ; // ͷ�ڵ�
	public ListNode tail = null ; // β�ڵ�
	
	public static void main(String[] args) {
		ListOperation operation = new ListOperation(); 
		ListNode node1 = new ListNode("muyan") ;
		ListNode node2 = new ListNode("moyang") ;
		ListNode node3 = new ListNode("muyanmoyang") ;
		ListNode node4 = new ListNode("yanshen") ;
		ListNode node5 = new ListNode("swyer") ;
		operation.insertNode2(node1);
		operation.insertNode2(node2);
		operation.insertNode2(node3);
		operation.insertNode2(node4);
		operation.insertNode2(node5);
		
		operation.printList(operation); // ��ӡ����
	}
	private void printList(ListOperation operation) {
		// TODO Auto-generated method stub
		ListNode tmp = null ;
		for(tmp = operation.getHead(); tmp!=null ; tmp = tmp.next){
			System.out.print(tmp.getData() + "��") ;
		}
	}
	
	private ListNode getHead() {
		// TODO Auto-generated method stub
		return head;
	}
	/*
	 *  ��ʼ������
	 */
	public void initList(ListNode node){
		head = node ;
		node.next = tail ;
	}
	
	/*
	 *  ͷ�巨 ����һ���ڵ�
	 */
	public void insertNode(ListNode node){
		if(head == null){
			initList(node);
		}else{
			ListNode tmp = head ;
			head = node ;
			node.next = tmp ;
		}
	}
	
	/*
	 *  β�巨 ����һ���ڵ�
	 */
	public void insertNode2(ListNode node){
		if(head == null){
			initList(node);
		}else{
			ListNode tmp = tail ;
			tail = node ;
			node.next = tmp ;
		}
	}
	
}
