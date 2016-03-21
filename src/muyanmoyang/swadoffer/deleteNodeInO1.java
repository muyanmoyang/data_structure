package muyanmoyang.swadoffer;

import org.omg.CORBA.FREE_MEM;

import muyanmoyang.data_structure.List_2.ListOperation;

/*
 *  在O(1)时间删除链表节点
 */
public class DeleteNodeInO1 {
	public static ListNode2 head; // 头节点
	public int pos = 0; // 节点的位置

	public static void main(String[] args) {
		DeleteNodeInO1 dn1 = new DeleteNodeInO1();
		dn1.addFirstNode("H");
		dn1.add(1, "K");
		dn1.add(2, "C");
		dn1.add(3, "M");
		dn1.add(4, "A");
		dn1.add(5, "R");
		// while(head != null){
		// System.out.print(head.data + "、");
		// head = head.next ;
		// }
		try {
			deleteNode(head, "R");
		} catch (Exception e) {
			System.out.println("链表里没有要删除的这个节点");
		}
		while (head != null && !head.data.equals("null")) {
			System.out.print(head.data + "、");
			head = head.next;
		}
	}

	/*
	 * 删除链表节点
	 */
	public static void deleteNode(ListNode2 node, String deleteNode)
			throws Exception {
		boolean flag = false; // 判断要删除的节点是否在链表中存在
		while (node != null) {
			if (node.data.equals(deleteNode)) {
				flag = true;
				break;
			} else {
				node = node.next;
			}
		}
		if (node.next != null) { // 要删除的节点不是尾节点
			ListNode2 tmp = node.next; // 指向要删节点node的后继节点tmp
			node.data = tmp.data; // 将后继节点tmp的值赋给node
			node.next = tmp.next; // 将tmp节点删除
			tmp = null;
			// }
			// else if(node!=null && node.next==null &&
			// node.data.equals(deleteNode)){ // 链表只有一个节点，要删除的是头节点
			// node = null ;
		} else { // 链表中有多个节点，要删除的是尾节点
			ListNode2 tmp = node;
			tmp.data = "null";
			node.data = tmp.data;
			tmp = null;
		}
		if (!flag) {
			throw new Exception();
		}
	}

	// 插入一个头节点
	public void addFirstNode(String data) {
		ListNode2 node = new ListNode2(data);
		node.next = head;
		head = node;
	}

	/*
	 * 在任意位置插入节点
	 */
	public void add(int index, String data) {
		ListNode2 node = new ListNode2(data);
		ListNode2 current = head;
		ListNode2 previous = head;
		while (pos != index) {
			previous = current;
			current = current.next;
			pos++;
		}
		node.next = current;
		previous.next = node;
		pos = 0;
	}
}

/*
 * 节点
 */
class ListNode2 {
	public String data;
	public ListNode2 next;

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public ListNode2 getNext() {
		return next;
	}

	public void setNext(ListNode2 next) {
		this.next = next;
	}

	public ListNode2(String data) {
		super();
		this.data = data;
	}

	public ListNode2(String data, ListNode2 next) {
		super();
		this.data = data;
		this.next = next;
	}
}