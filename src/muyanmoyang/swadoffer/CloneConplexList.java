package muyanmoyang.swadoffer;

import java.util.HashMap;

/**
 *  输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点）
 * @author hadoop
 *
 */
public class CloneConplexList {
	public RandomListNode Clone(RandomListNode pHead)
    {
		RandomListNode p = pHead ;
		// 1 
		while(p!=null){
			RandomListNode tmp = null ;
			tmp.label = p.label ;
			tmp.next = p.next ;
			tmp.random = null ;
			p.next = tmp ;
			p = tmp.next ;
		}
		// 2
		p = pHead ;
		while(p!=null){
			RandomListNode clone = p.next ;  //复制的节点
			if(p.random != null){    // 若要复制节点的随机节点不为空
				clone.random = p.random.next ;  // 复制节点的随即节点设为要复制节点的下一节点
			}
			p = clone.next ; // 
		}
		// 3
		p = pHead ;
		HashMap map = new HashMap() ;
		
		return pHead;
    }
}

class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
