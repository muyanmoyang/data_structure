package muyanmoyang.data_structure.List;

import java.util.LinkedList;


public class ListOperation {
	private ListNode head = null ; //ͷ�ڵ�
	private ListNode tail = null ; //β�ڵ�
	
	/*
	 * ��ʼ��һ����������head ��
	 */
	public void initList(ListNode node){
		head = node ;
		node.next = tail ;
	}
	
	/*
	 *  ����һ��Ԫ��(ͷ�巨)
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
	 *  ɾ��һ��Ԫ�� 
	 */
	public void deleteNode(ListNode node , ListOperation list){
		if(head == null){
			return ;
		}
		ListNode tmp = null ;
		for(tmp=list.getHead(); tmp!=null ; tmp=tmp.next){
			if(tmp.next !=null && tmp.next.getKey().equals(node.getKey())){
				if(tmp.next.next != null){
					tmp.next = tmp.next.next ;	
				}else{
					tmp.next = null ;
				}
			}
		}
	}
	/*
	 * ��ӡ����
	 */
	public void printList(ListOperation myList){
		ListNode tmp =null;
        for(tmp = myList.getHead(); tmp!=null ;tmp = tmp.next){
            System.out.println(tmp.getKey());
        }
    }
	
	public ListNode getHead(){
        return head;
    }
	
	public static void main(String[] args) {
		ListOperation operation = new ListOperation(); 
		ListNode node1 = new ListNode("muyan") ;
		ListNode node2 = new ListNode("moyang") ;
		ListNode node3 = new ListNode("muyanmoyang") ;
		ListNode node4 = new ListNode("yanshen") ;
		ListNode node5 = new ListNode("swyer") ;
		operation.insertNode(node1);
		operation.insertNode(node2);
		operation.insertNode(node3);
		operation.insertNode(node4);
		operation.insertNode(node5);
		operation.deleteNode(node4, operation);
		operation.printList(operation);
	}
}
