package muyanmoyang.data_structure.List_2;

public class ListNode {
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
