package muyanmoyang.data_structure.List;

public class ListNode {
	public String key;//�ڵ��ֵ
    public ListNode next;//ָ����һ����ָ��'
	
    public ListNode(String key){//��ʼ��head
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
