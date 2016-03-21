package muyanmoyang.swadoffer;

import java.util.Stack;

/**
 * ¶þ²æÊ÷µÄ¾µÏñ
 * 
 * @author hadoop
 * 
 */
public class MirrorTree {
	public static void main(String[] args) {
		
	}

	/*
	 * ¶þ²æÊ÷¾µÏñ
	 */
	public void Mirror(TreeNode root) {
		if (root == null) {
			return;
		}
		if (root.left == null && root.right == null) {
			return;
		}
		TreeNode tmpTree = root.left;
		root.left = root.right;
		root.right = tmpTree;
		if (root.left != null) {
			Mirror(root.left);
		}
		if (root.right != null) {
			Mirror(root.right);
		}
	}

	/*
	 * ¶þ²æÊ÷¾µÏñ£¨·ÇµÝ¹é£©
	 */
	public void MirrorWithRecursion(TreeNode root) {
		if (root == null) {
			return;
		}
		if (root.left == null && root.right == null) {
			return;
		}
		Stack<TreeNode> stack = new Stack<TreeNode>() ;
		stack.push(root) ;
		while(root.left!=null || root.right!=null){
			TreeNode tmpTree = stack.firstElement() ; // Õ»¶¥½Úµã
			stack.pop() ; // Õ»¶¥½Úµã³öÕ»
			if(tmpTree.left!=null || tmpTree.right!=null){
				TreeNode node = tmpTree.left ;
				tmpTree.left = tmpTree.right ;
				tmpTree.right = node ;
			}
			if(tmpTree.left != null){
				stack.push(tmpTree.left) ;
			}
			if(tmpTree.right != null){
				stack.push(tmpTree.right) ;
			}
		}
	}
}
