package muyanmoyang.swadoffer;

import java.util.HashMap;

/**
 *  ����һ����������ÿ���ڵ����нڵ�ֵ���Լ�����ָ�룬һ��ָ����һ���ڵ㣬��һ������ָ��ָ������һ���ڵ㣩
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
			RandomListNode clone = p.next ;  //���ƵĽڵ�
			if(p.random != null){    // ��Ҫ���ƽڵ������ڵ㲻Ϊ��
				clone.random = p.random.next ;  // ���ƽڵ���漴�ڵ���ΪҪ���ƽڵ����һ�ڵ�
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
