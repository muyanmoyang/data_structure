package muyanmoyang.swadoffer;

/**
 *  合并两个排序的链表
 * @author hadoop
 *
 */
public class CombineTwoList {
	public MyListNode Merge(MyListNode list1,MyListNode list2) {
		if(list1==null && list2!=null){
			return list2 ;
		}else if(list1!=null && list2==null){
			return list1 ;
		}else{
			MyListNode first = list1 ;
			MyListNode second = list2 ;
			MyListNode result = new MyListNode(-1) ;
			MyListNode third = result ;
			
			while(first!=null && second!=null){
				if(first.data < second.data){
					third.next = first ;
					third = third.next ;
					first = first.next ;
				}else{
					third.next = second ;
					third = third.next ;
					second = second.next ;
				}
			}
			while(first!=null){
				third.data = first.data ;
				first = first.next ;
			}
			while(second!=null){
				third.data = second.data ;
				second = second.next ;
			}
			return third ;
		}
    }
}
