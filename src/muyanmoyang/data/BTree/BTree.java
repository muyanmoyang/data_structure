package muyanmoyang.data.BTree;

import java.awt.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Stack;

public class BTree {
	static BtNode root = initTree() ;
	static int numOfLeafNodes = 0;
	public static void main(String[] args) {
		//初始化
		BtNode bt = initTree() ;
		//先序遍历二叉树
		System.out.print("\n先序遍历:");  
		preOrder(bt) ;                  // 先序遍历
		System.out.print("\n先序遍历(非递归):");
		preOrderWithoutRecursion(bt) ;  // 先序遍历(非递归)
		System.out.print("\n中序遍历:");
		inOrderWithoutRecursion(bt);    // 中序遍历
		System.out.print("\n后序遍历:");
		postOrder(bt) ;					// 后序遍历
		System.out.print("\n层次遍历:");
		levelOrder(bt) ;                // 层次遍历
		System.out.print("\n二叉树的深度:" + getDepthOfBTree(bt)); 
		System.out.print("\n二叉树的节点个数:" + getNumOfNodes(bt));
		System.out.println("\n二叉树的叶子节点个数:" + getNumOfLeafNodes(bt)); 
		System.out.println(is_in_Tree(bt,"F"));

		// 求指定节点的parent节点
		System.out.print("\n查询双亲节点，请输入以下节点中的一个: ");
		levelOrder(bt) ;
		System.out.println();
		try{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String str = br.readLine() ;
			BtNode parent = parent(str);
			System.out.println("所求双亲为:" + parent.data);
		}catch(NullPointerException e){
			System.out.println("没有这个节点");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); 
		}
		
		// 查找指定的节点
		BtNode findNode = findNode(bt,"G") ;
		BtNode parent2 = parent(findNode.data);
		System.out.println("所求双亲为:" + parent2.data);
	}
	/*
	 * 初始化树
	 */
	private static BtNode initTree(){
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
	 *  先序遍历
	 */
	private static void preOrder(BtNode bt){
		if(bt == null){
			return ; 
		}else{
			System.out.print(bt.data + "、") ;
			if(bt.lchild != null){
				preOrder(bt.lchild) ;
			}
			if(bt.rchild != null){
				preOrder(bt.rchild) ;
			}
		}
	}
	
	/*
	 *  先序遍历 (非递归)
	 */
	private static void preOrderWithoutRecursion(BtNode bt){
		if(bt == null){
			return ;
		}
		Stack<BtNode> stack = new Stack<BtNode>() ;
		BtNode p = bt ;
		while(p!=null || !stack.isEmpty()){
			if(p!=null){
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
	 *  中序遍历 (非递归实现)
	 */
	private static void inOrderWithoutRecursion(BtNode bt){
		if(bt == null){
			return ;
		}
		Stack<BtNode> stack = new Stack<BtNode>() ;
		BtNode p = bt ;
		while(p!=null || !stack.isEmpty()){
			if(p != null){
				stack.push(p) ;
				p = p.lchild ;
			}else
			{
				p = stack.pop() ;
				System.out.print(p.data + "、");
				p = p.rchild ;
			}
		}
	}
	/*
	 *  后序遍历 (双栈实现)
	 */
	private static void postOrder(BtNode bt){
		if(bt == null){
			return ;
		}
		Stack<BtNode> stack = new Stack<BtNode>() ;
		Stack<BtNode> out = new Stack<BtNode>() ;
		BtNode p = bt ;
		while(p!=null || !stack.isEmpty()){
			if(p != null){
				stack.push(p); 
				out.push(p);
				p = p.rchild ;
			}else{
				p = stack.pop().lchild ;
			}
		}
		while (!out.isEmpty()) {
			p = out.pop() ;
			System.out.print(p.data + "、");	
		}
	}
	
	/*
	 * 层次遍历
	 */
	private static void levelOrder(BtNode bt){
		if(bt == null){
			return ;
		}
		LinkedList queue = new LinkedList() ;
		queue.add(bt) ;
		while(!queue.isEmpty()){
			BtNode tmpNode = (BtNode) queue.remove(0) ;
			System.out.print(tmpNode.data + "、");
			if(tmpNode.lchild != null){
				queue.add(tmpNode.lchild) ;
			}
			if(tmpNode.rchild != null){
				queue.add(tmpNode.rchild);
			}
		}
	}
	
	/*
	 * 求二叉树的深度（递归实现）
	 */
	private static int getDepthOfBTree(BtNode bt){
		if(bt == null){
			return 0 ;
		}
		int a , b ;
		a = getDepthOfBTree(bt.lchild) ;
		b = getDepthOfBTree(bt.rchild) ;
		return (a > b ? a : b) + 1 ;
	}
	
	/*
	 *  求二叉树的节点个数(递归实现)
	 */
	private static int getNumOfNodes(BtNode bt){
		if(bt == null){
			return 0 ;
		}
		return getNumOfNodes(bt.lchild) + getNumOfNodes(bt.rchild) + 1 ;
	}
	
	/*
	 *  求二叉树的叶子节点个数
	 */
	private static int getNumOfLeafNodes(BtNode bt){
		if(bt == null){
			return 0;
		}
		if(bt.lchild == null && bt.rchild == null){
			return 1 ;
		}
		return getNumOfLeafNodes(bt.lchild) + getNumOfLeafNodes(bt.rchild) ;
	}
	/*
	 *  判断某个值是否在某个节点的子树中
	 */
	private static boolean is_in_Tree(BtNode bt,String data){
		if(bt == null){
			return false ;
		}
		if(bt.data.equals(data)){
			return true ;
		}else{
			boolean isIn = false ;
			if(!isIn && bt.lchild != null){
				isIn = is_in_Tree(bt.lchild, data);
			}
			if(!isIn && bt.rchild != null){
				isIn = is_in_Tree(bt.rchild, data);
			}
			return isIn ;
		}
	}
	
	/*
	 *  求双亲节点
	 */
	private static BtNode parent(String elem){
		return (root==null || root.data.equals(elem))? null : parent(root,elem) ;
	}
	private static BtNode parent(BtNode subTree, String elem) {
		if(subTree == null){
			return null ;
		}
		if((subTree.lchild!=null && subTree.lchild.data.equals(elem)) || (subTree.rchild!= null && subTree.rchild.data.equals(elem))){
			return subTree ;
		}
		BtNode p ;
		if((p=parent(subTree.lchild, elem))!=null){
			return p ;
		}else
			return parent(subTree.rchild, elem) ;
	}
	/*
	 * 在释放某个结点时，该结点的左右子树都已经释放，  所以应该采用后续遍历，当访问某个结点时将该结点的存储空间释放
	 */
	private static void removeSubTree(BtNode subTree){
		if(subTree != null){
			removeSubTree(subTree.lchild);
			removeSubTree(subTree.rchild); 
			subTree = null ;
		}
	}
	
	/*
	 *  查找指定节点，输入节点的data，返回节点的BtNode对象
	 */
	private static BtNode findNode(BtNode bt,String findData){
		BtNode findResultNode = null ;
		if(bt == null){
			return null ;
		}
		if(bt.data.equals(findData)){
			return bt ;
		}
		if(bt.lchild != null){
			findResultNode = findNode(bt.lchild, findData) ;
			if(findResultNode!=null) 
				return findResultNode ;
		}
		if(bt.rchild != null){
			findResultNode = findNode(bt.rchild, findData) ;
			if(findResultNode!=null) 
				return findResultNode ;
		}
		return null ;
	}
}
