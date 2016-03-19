package muyanmoyang.data.Btree2;

import java.util.LinkedList;
import java.util.Stack;
import java.util.Vector;

/**
 *  二叉树基本操作
 * @author hadoop
 *
 */
public class BtTree {
	
	static BtNode root = init() ;// 初始化树
	public static void main(String[] args) {
		
		System.out.print("\n先序遍历:");  
		preOrder(root); // 先序遍历（递归）
		
		System.out.print("\n先序遍历(非递归):");  
		preOrderWithoutRecursion(root); // 先序遍历（非递归）
		
		System.out.print("\n中序遍历(非递归):");
		inOrderWithoutRecursion(root);
		
		System.out.print("\n后序遍历(双栈):");
		postOrder(root); // 后序遍历（双栈实现）
		
		System.out.print("\n层次遍历:");
		levelOrder(root); // 层次遍历
		
		System.out.print("\n二叉树的深度:"); 
		System.out.print(computeDepth(root)) ; //求二叉树的深度(递归)
		
		System.out.print("\n二叉树的节点个数:");
		System.out.print(computeNodeNum(root)); // 求二叉树的节点个数(递归)
		
		System.out.print("\n二叉树的叶子节点个数:");
		System.out.println(computeLeafNum(root)) ;
		
		String data = "B" ;
		try{
			BtNode parent = getObjOfInputNode(data) ; // 获取双亲节点
			System.out.print("\n获取" + data + "的双亲节点:");
			System.out.print(parent.data) ;
		}catch(Exception e){
			System.out.println("为空或者是根节点-----没有双亲节点") ;
		}
		
		String findData = "I" ;
		System.out.print("\n查找节点:" + findData + "--------");
		System.out.println(findNode(root,findData)==null ? "没有这个节点..." : "确有其节点，其父节点是：" + 
						getObjOfInputNode(findData).data) ;
 	}
	
	/*
	 * 初始化
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
	 * 先序遍历(递归)
	 */
	private static void preOrder(BtNode bt){
		if(bt == null){
			return  ;
		}
		System.out.print(bt.data + "、");
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
				System.out.print(p.data + "、");
				stack.push(p) ;
				p = p.lchild ;
			}else{
				p = stack.pop() ;
				p = p.rchild ;
			}
		}
	}
	
	/*
	 *  中序遍历(非递归)
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
				System.out.print(p.data + "、");
				p = p.rchild ;
			}
		}
	}
	
	/*
	 * 后序遍历（双栈实现）
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
			System.out.print(p.data + "、");
		}
	}
	/*
	 *  层次遍历
	 */
	public static void levelOrder(BtNode bt){
		if(bt == null){
			return ;
		}
		LinkedList<BtNode> queue = new LinkedList<BtNode>() ;
		queue.add(bt) ;
		while(!queue.isEmpty()){
			BtNode tmpNode = queue.remove(0) ;
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
	 *  求二叉树的深度
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
	 *  求二叉树的节点个数(递归)
	 */
	private static int computeNodeNum(BtNode bt){
		if(bt == null){
			return 0 ; 
		}
		return computeNodeNum(bt.lchild) + computeNodeNum(bt.rchild) + 1 ;
	}
	/*
	 *  求二叉树的叶子节点个数
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
	 *  求输入节点的双亲节点
	 */
	private static BtNode getObjOfInputNode(String elem){
		return (root == null || root.data.equals(elem) ? null : parent(root,elem)) ;
	}
	/*
	 *  求指定节点的双亲节点
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
	 *  查找指定节点，返回该节点的对象
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
