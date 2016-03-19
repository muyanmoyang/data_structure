package muyanmoyang.data.Btree2;

import java.util.LinkedList;
import java.util.Stack;
import java.util.Vector;

/**
 *  ��������������
 * @author hadoop
 *
 */
public class BtTree {
	
	static BtNode root = init() ;// ��ʼ����
	public static void main(String[] args) {
		
		System.out.print("\n�������:");  
		preOrder(root); // ����������ݹ飩
		
		System.out.print("\n�������(�ǵݹ�):");  
		preOrderWithoutRecursion(root); // ����������ǵݹ飩
		
		System.out.print("\n�������(�ǵݹ�):");
		inOrderWithoutRecursion(root);
		
		System.out.print("\n�������(˫ջ):");
		postOrder(root); // ���������˫ջʵ�֣�
		
		System.out.print("\n��α���:");
		levelOrder(root); // ��α���
		
		System.out.print("\n�����������:"); 
		System.out.print(computeDepth(root)) ; //������������(�ݹ�)
		
		System.out.print("\n�������Ľڵ����:");
		System.out.print(computeNodeNum(root)); // ��������Ľڵ����(�ݹ�)
		
		System.out.print("\n��������Ҷ�ӽڵ����:");
		System.out.println(computeLeafNum(root)) ;
		
		String data = "B" ;
		try{
			BtNode parent = getObjOfInputNode(data) ; // ��ȡ˫�׽ڵ�
			System.out.print("\n��ȡ" + data + "��˫�׽ڵ�:");
			System.out.print(parent.data) ;
		}catch(Exception e){
			System.out.println("Ϊ�ջ����Ǹ��ڵ�-----û��˫�׽ڵ�") ;
		}
		
		String findData = "I" ;
		System.out.print("\n���ҽڵ�:" + findData + "--------");
		System.out.println(findNode(root,findData)==null ? "û������ڵ�..." : "ȷ����ڵ㣬�丸�ڵ��ǣ�" + 
						getObjOfInputNode(findData).data) ;
 	}
	
	/*
	 * ��ʼ��
	 */
	private static BtNode init(){
		
		BtNode aBtNode = new BtNode("A", null, null);  
        BtNode bBtNode = new BtNode("B", null, null);  
        BtNode cBtNode = new BtNode("C", null, null);  
        BtNode dBtNode = new BtNode("D", null, null);  
        BtNode eBtNode = new BtNode("E", null, null);  
        BtNode fBtNode = new BtNode("F", null, null);  
        BtNode gBtNode = new BtNode("G", null, null);  
        BtNode hBtNode = new BtNode("H", null, null);  
        
        aBtNode.setLchild(bBtNode);  
        aBtNode.setRchild(cBtNode);  
        bBtNode.setLchild(dBtNode);  
        bBtNode.setRchild(eBtNode);  
        cBtNode.setLchild(fBtNode);  
        cBtNode.setRchild(gBtNode);  
        fBtNode.setRchild(hBtNode);   
        return  aBtNode ;  
	}
	
	/*
	 * �������(�ݹ�)
	 */
	private static void preOrder(BtNode bt){
		if(bt == null){
			return  ;
		}
		System.out.print(bt.data + "��");
		if(bt.lchild != null){
			preOrder(bt.lchild);
		}
		if(bt.rchild != null){
			preOrder(bt.rchild); 
		}
	}
	
	private static void preOrderWithoutRecursion(BtNode bt){
		if(bt == null){
			return ;
		}
		Stack<BtNode> stack = new Stack<BtNode>() ;
		BtNode p = bt ;
		while(p!=null || !stack.isEmpty()){
			if(p != null){
				System.out.print(p.data + "��");
				stack.push(p) ;
				p = p.lchild ;
			}else{
				p = stack.pop() ;
				p = p.rchild ;
			}
		}
	}
	
	/*
	 *  �������(�ǵݹ�)
	 */
	private static void inOrderWithoutRecursion(BtNode bt){
		if(bt == null){
			return ;
		}
		Stack<BtNode> stack = new Stack<BtNode>() ;
		BtNode p = bt ;
		while(p != null || !stack.isEmpty()){
			if(p != null){
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
	 * ���������˫ջʵ�֣�
	 */
	private static void postOrder(BtNode bt){
		if(bt == null){
			return ;
		}
		Stack<BtNode> stack  = new Stack<BtNode>() ;
		Stack<BtNode> out  = new Stack<BtNode>() ;
		BtNode p = bt ; 
		while(p!=null || !stack.isEmpty()){
			if(p != null){
				stack.push(p) ;
				out.push(p) ;
				p = p.rchild ;
			}else{
				p = stack.pop() ;
				p = p.lchild ;
			}
		}
		while(!out.isEmpty()){
			p = out.pop() ;
			System.out.print(p.data + "��");
		}
	}
	/*
	 *  ��α���
	 */
	public static void levelOrder(BtNode bt){
		if(bt == null){
			return ;
		}
		LinkedList<BtNode> queue = new LinkedList<BtNode>() ;
		queue.add(bt) ;
		while(!queue.isEmpty()){
			BtNode tmpNode = queue.remove(0) ;
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
	 *  ������������
	 */
	private static int computeDepth(BtNode bt){
		if(bt == null){
			return 0 ;
		}
		int a = computeDepth(bt.lchild) ;
		int b = computeDepth(bt.rchild) ;
		return (a>b? a : b) + 1 ;
	}
	
	/*
	 *  ��������Ľڵ����(�ݹ�)
	 */
	private static int computeNodeNum(BtNode bt){
		if(bt == null){
			return 0 ; 
		}
		return computeNodeNum(bt.lchild) + computeNodeNum(bt.rchild) + 1 ;
	}
	/*
	 *  ���������Ҷ�ӽڵ����
	 */
	private static int computeLeafNum(BtNode bt){
		if(bt == null){
			return 0 ;
		}
		if(bt.lchild == null && bt.rchild == null){
			return 1 ;
		}else{
			return computeLeafNum(bt.lchild) + computeLeafNum(bt.rchild) ;
		}
	}
	
	/**
	 *  ������ڵ��˫�׽ڵ�
	 */
	private static BtNode getObjOfInputNode(String elem){
		return (root == null || root.data.equals(elem) ? null : parent(root,elem)) ;
	}
	/*
	 *  ��ָ���ڵ��˫�׽ڵ�
	 */
	private static BtNode parent(BtNode bt, String elem) {
		if(bt == null){
			return null ;
		}
		if((bt.lchild!=null && bt.lchild.data.equals(elem)) || (bt.rchild!=null && bt.rchild.data.equals(elem))){
			return bt ;
		}
		BtNode p ;
		if((p=parent(bt.lchild, elem))!=null){
			return p ;
		}else{
			return parent(bt.rchild, elem) ;
		}
	}
	
	/*
	 *  ����ָ���ڵ㣬���ظýڵ�Ķ���
	 */
	private static BtNode findNode(BtNode bt ,String findData){
		if(bt == null){
			return null;
		}
		if(bt.data.equals(findData)){
			return bt ;
		}
		if(bt.lchild != null){
			BtNode findResultNode  = findNode(bt.lchild, findData) ;
			if(findResultNode !=null){
				return findResultNode  ;
			}
		}
		if(bt.rchild != null){
			BtNode findResultNode  = findNode(bt.rchild, findData) ;
			if(findResultNode !=null){
				return findResultNode  ;
			}
		}
		return null ;
	}
}
