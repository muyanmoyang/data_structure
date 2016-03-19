package muyanmoyang.data.Btree2;

import java.util.LinkedList;
import java.util.Stack;

/**
 *  二叉排序树
 * @author hadoop
 *
 */
public class BSortTree {
	public static void main(String[] args) {
		BtNode2 bt = null  ; 
		int[] array = {143,54,36,5,78,6,98,79,214,5436};
		for(int i=0; i<array.length; i++){
			if(bt == null){
				bt = new BtNode2(array[0], null ,null) ;
			}else{
				insertNode(bt,array[i]) ;
			}
		}
		levelOrder(bt);  // 层次遍历
		System.out.println("\n二叉排序树：层次遍历......") ;
		inOrderWithoutRecursion(bt); // 中序遍历
	}
	/*
	 *  插入
	 */
	private static void insertNode(BtNode2 bt,int value){
		if(value < bt.data){  
            if(bt.lchild == null){
                bt.lchild = new BtNode2(value,null,null) ;
            }else{
            	insertNode(bt.lchild, value) ;
            }  
        }else if(value > bt.data){
        	if(bt.rchild == null){
        		bt.rchild = new BtNode2(value,null,null) ;
        	}else{
        		insertNode(bt.rchild, value) ;
        	}
        }
	}
	/*
	 *  层次遍历
	 */
	public static void levelOrder(BtNode2 bt){
		if(bt == null){
			return ;
		}
		LinkedList<BtNode2> queue = new LinkedList<BtNode2>() ;
		queue.add(bt) ;
		while(!queue.isEmpty()){
			BtNode2 tmpNode = queue.remove(0) ;
			System.out.print(tmpNode.data + "、");
			if(tmpNode.lchild != null){
				queue.add(tmpNode.lchild) ;
			}
			if(tmpNode.rchild != null){
				queue.add(tmpNode.rchild) ;
			}
		}
	}
	
	/*
	 * 中序遍历
	 */
	private static void inOrderWithoutRecursion(BtNode2 bt){
		if(bt == null){
			return ;
		}
		Stack<BtNode2> stack = new Stack<BtNode2>() ;
		BtNode2 p = bt;
		while(p!=null || !stack.isEmpty()){
			if(p!=null){
				stack.push(p) ;
				p = p.lchild ;
			}else{
				p = stack.pop() ;
				System.out.print(p.data + "、");
				p = p.rchild ;
			}
		}
	}
	
	/*
	 * 由先序遍历和中序遍历求后序遍历结果
	 */
	public static String res = "";
	private static void cal_postOrder(String preOrder, String inOrder){
		boolean state = StringEquals(preOrder,inOrder);
		if(state == false){
			return ;
		}
		if(inOrder.length()==0)
			return ;
		if(inOrder.length()==1){
			res += inOrder;
			return ;
		}
		char root = preOrder.charAt(0);   // 先序遍历中的第一个元素 ： 即根节点root
		int mid = findchar(inOrder,root);    // 在中序遍历中查找根节点的位置  返回的是中序遍历中根节点所在的序号
		String left = inOrder.substring(0,mid);  //  在中序遍历中，以根节点位置为划分，返回根节点左侧的字符串
		String right = inOrder.substring(mid+1); //  在中序遍历中，以根节点位置为划分，返回根节点右侧的字符串
		cal_postOrder(preOrder.substring(1,left.length()+1),left);  // 对左侧的字符串递归调用该函数 
		cal_postOrder(preOrder.substring(1+left.length()),right);   // 对右侧的字符串递归调用该函数
		res += String.valueOf(root);

		return ;
	}
	
	private static boolean StringEquals(String a1, String a2) {
		boolean state= true;
		if(a1.length()!=a2.length()){
			state = false;
		}
		if(a1.length()==a2.length()){
			for(int i=0;i<a1.length();i++){
				if(findchar(a2,a1.charAt(i))==-1)
					state = false;
			}
		}
		return state ;
	}
//	private static int findchar(String a2, char charAt) {
//		char[] cha = a2.toCharArray() ;
//		for(int i=0; i<cha.length; i++){
//			if(cha[i]==charAt){
//				return 1 ;
//			}
//		}
//		return -1;
//	}
	 static int findchar(String s,char a){
		  for(int i=0;i<s.length();i++){
		   if(a==s.charAt(i))
		    return i;
		  }
		  return -1;
	 }
}
