package muyanmoyang.swadoffer;

import org.omg.CORBA.FREE_MEM;

import muyanmoyang.data_structure.List_2.ListOperation;

/*
 *  ��O(1)ʱ��ɾ������ڵ�
 */
public class DeleteNodeInO1 {
	public static ListNode2 head; // ͷ�ڵ�
	public int pos = 0; // �ڵ��λ��

	public static void main(String[] args) {
		DeleteNodeInO1 dn1 = new DeleteNodeInO1();
		dn1.addFirstNode("H");
		dn1.add(1, "K");
		dn1.add(2, "C");
		dn1.add(3, "M");
		dn1.add(4, "A");
		dn1.add(5, "R");
		// while(head != null){
		// System.out.print(head.data + "��");
		// head = head.next ;
		// }
		try {
			deleteNode(head, "R");
		} catch (Exception e) {
			System.out.println("������û��Ҫɾ��������ڵ�");
		}
		while (head != null && !head.data.equals("null")) {
			System.out.print(head.data + "��");
			head = head.next;
		}
	}

	/*
	 * ɾ������ڵ�
	 */
	public static void deleteNode(ListNode2 node, String deleteNode)
			throws Exception {
		boolean flag = false; // �ж�Ҫɾ���Ľڵ��Ƿ��������д���
		while (node != null) {
			if (node.data.equals(deleteNode)) {
				flag = true;
				break;
			} else {
				node = node.next;
			}
		}
		if (node.next != null) { // Ҫɾ���Ľڵ㲻��β�ڵ�
			ListNode2 tmp = node.next; // ָ��Ҫɾ�ڵ�node�ĺ�̽ڵ�tmp
			node.data = tmp.data; // ����̽ڵ�tmp��ֵ����node
			node.next = tmp.next; // ��tmp�ڵ�ɾ��
			tmp = null;
			// }
			// else if(node!=null && node.next==null &&
			// node.data.equals(deleteNode)){ // ����ֻ��һ���ڵ㣬Ҫɾ������ͷ�ڵ�
			// node = null ;
		} else { // �������ж���ڵ㣬Ҫɾ������β�ڵ�
			ListNode2 tmp = node;
			tmp.data = "null";
			node.data = tmp.data;
			tmp = null;
		}
		if (!flag) {
			throw new Exception();
		}
	}

	// ����һ��ͷ�ڵ�
	public void addFirstNode(String data) {
		ListNode2 node = new ListNode2(data);
		node.next = head;
		head = node;
	}

	/*
	 * ������λ�ò���ڵ�
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
 * �ڵ�
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