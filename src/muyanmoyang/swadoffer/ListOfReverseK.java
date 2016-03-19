package muyanmoyang.swadoffer;

/**
 * 链表中倒数第K个节点(只遍历一遍链表)
 * 
 * @author hadoop
 * 
 */
public class ListOfReverseK {
	public static ListNode3 head; // 头节点
	public int pos = 0; // 节点的位置

	public static void main(String[] args) {
		ListOfReverseK lrk = new ListOfReverseK();
		lrk.addFirstNode(1);
		lrk.add(1, 78);
		lrk.add(2, 215);
		lrk.add(3, 8764);
		lrk.add(4, 1342);
		lrk.add(5, 6);
		try{
			ListNode3 node = lrk.FindKthToTail(head, 4) ;
			System.out.println("result = " + node.data);
		}catch(NullPointerException e){
			System.out.println("输入参数有误！请确认后再次输入...") ;
		}
		
	}
	public ListNode3 FindKthToTail(ListNode3 head, int k) {
		if(head==null || k<0){
			return null ;
		}
		ListNode3 index1 = head; // first pointer
		ListNode3 index2 = head; // second pointer
		for (int i = 1; i <= k; i++) {
			if(index1.next!=null){
				index1 = index1.next;
			}else{
                return null ;
            }
		}
		while (index1 != null) {
			index1 = index1.next;
			index2 = index2.next;
		}
		return index2;
	}
	
//	public ListNode3 FindKthToTail(ListNode3 head,int k) {
//		if(k<=0) return null;
//         ListNode3 p1 = head;
//         ListNode3 p2 = head;
//         //p2向前移动k个节点
//         for(int i=0;i<k-1;i++) {
//             if(p2==null) return null;
//             p2 = p2.next;
//         }
//         if(p2==null) return null;
//         while(p2.next!=null) {
//             p1=p1.next;
//             p2=p2.next;
//         }
//         return p1;
//    }
	
	// 插入一个头节点
	public void addFirstNode(int data) {
		ListNode3 node = new ListNode3(data);
		node.next = head;
		head = node;
	}

	/*
	 * 在任意位置插入节点
	 */
	public void add(int index, int data) {
		ListNode3 node = new ListNode3(data);
		ListNode3 current = head;
		ListNode3 previous = head;
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

class ListNode3 {
	int data;
	ListNode3 next;

	public ListNode3(int data) {
		this.data = data;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public ListNode3 getNext() {
		return next;
	}

	public void setNext(ListNode3 next) {
		this.next = next;
	}

	public ListNode3(int data, ListNode3 next) {
		super();
		this.data = data;
		this.next = next;
	}
}