package muyanmoyang.swadoffer;

/**
 * 反转链表
 * 
 * @author hadoop
 * 
 */
public class ReverseList {
	public static MyListNode head; // 头节点
	public int pos = 0; // 节点的位置

	public static void main(String[] args) {
		ReverseList mln = new ReverseList() ;
		mln.addFirstNode(1);
		mln.add(1, 78);
		mln.add(2, 215);
		mln.add(3, 8764);
		mln.add(4, 1342);
		mln.add(5, 6);
		System.out.println("原链表...") ;
		MyListNode tmp = head ;
		while(tmp!=null){
			System.out.print(tmp.data + "、");
			tmp = tmp.next ;
		}
		System.out.println("\n反转链表...") ;
		MyListNode new_head = mln.ReverseList2(head) ;
		while(new_head!=null){
			System.out.print(new_head.data + "、");
			new_head = new_head.next ;
		}
	}
	/*
	 *  反转链表，非递归
	 */
	public MyListNode ReverseList(MyListNode head) {
		if(head==null || head.next == null){
			return head ;
		}
		MyListNode pre = null ;
		MyListNode cur = head ;
		MyListNode next = null ;
		while(cur != null){
			next = cur.next ; // 存贮后继节点，防止丢失
			cur.next = pre;
			pre = cur ;
			cur = next ;
		}
		return pre ;
	}
	
	/*
	 *  反转链表，递归
	 */
	public MyListNode ReverseList2(MyListNode head) {
		if(head==null || head.next == null){
			return head ;
		}
		MyListNode reverseNode = ReverseList(head.next) ;
		head.next.setNext(head) ;
		head.setNext(null) ;
		return reverseNode ;
	}

	// 插入一个头节点
	public void addFirstNode(int data) {
		MyListNode node = new MyListNode(data);
		node.next = head;
		head = node;
	}

	/*
	 * 在任意位置插入节点
	 */
	public void add(int index, int data) {
		MyListNode node = new MyListNode(data);
		MyListNode current = head;
		MyListNode previous = head;
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

class MyListNode {
	int data;
	MyListNode next;

	public MyListNode(int data) {
		super();
		this.data = data;
	}

	public MyListNode(int data, MyListNode next) {
		super();
		this.data = data;
		this.next = next;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public MyListNode getNext() {
		return next;
	}

	public void setNext(MyListNode next) {
		this.next = next;
	}
}
