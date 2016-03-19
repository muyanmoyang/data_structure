package muyanmoyang.data_structure.List;

public class ListNode {
	public String key;//节点的值
    public ListNode next;//指向下一个的指针'
	
    public ListNode(String key){//初始化head
        this.key = key;
        this.next = null;
    }
    public ListNode(String key,ListNode next){
        this.key = key;
        this.next = next;
    }
    
    public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public ListNode getNext() {
		return next;
	}
	public void setNext(ListNode next) {
		this.next = next;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Node_Single [key=" + key + ", next=" + next + "]" ;
	}
	
}
