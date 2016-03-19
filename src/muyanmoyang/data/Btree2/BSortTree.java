package muyanmoyang.data.Btree2;

import java.util.LinkedList;
import java.util.Stack;

/**
 *  ����������
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
		levelOrder(bt);  // ��α���
		System.out.println("\n��������������α���......") ;
		inOrderWithoutRecursion(bt); // �������
	}
	/*
	 *  ����
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
	 *  ��α���
	 */
	public static void levelOrder(BtNode2 bt){
		if(bt == null){
			return ;
		}
		LinkedList<BtNode2> queue = new LinkedList<BtNode2>() ;
		queue.add(bt) ;
		while(!queue.isEmpty()){
			BtNode2 tmpNode = queue.remove(0) ;
			System.out.print(tmpNode.data + "��");
			if(tmpNode.lchild != null){
				queue.add(tmpNode.lchild) ;
			}
			if(tmpNode.rchild != null){
				queue.add(tmpNode.rchild) ;
			}
		}
	}
	
	/*
	 * �������
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
				System.out.print(p.data + "��");
				p = p.rchild ;
			}
		}
	}
	
	/*
	 * �����������������������������
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
		char root = preOrder.charAt(0);   // ��������еĵ�һ��Ԫ�� �� �����ڵ�root
		int mid = findchar(inOrder,root);    // ����������в��Ҹ��ڵ��λ��  ���ص�����������и��ڵ����ڵ����
		String left = inOrder.substring(0,mid);  //  ����������У��Ը��ڵ�λ��Ϊ���֣����ظ��ڵ������ַ���
		String right = inOrder.substring(mid+1); //  ����������У��Ը��ڵ�λ��Ϊ���֣����ظ��ڵ��Ҳ���ַ���
		cal_postOrder(preOrder.substring(1,left.length()+1),left);  // �������ַ����ݹ���øú��� 
		cal_postOrder(preOrder.substring(1+left.length()),right);   // ���Ҳ���ַ����ݹ���øú���
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
