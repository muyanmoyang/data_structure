package muyanmoyang.swadoffer;

import java.util.Stack;

/**
 * �������ľ���
 * 
 * @author hadoop
 * 
 */
public class MirrorTree {
	public static void main(String[] args) {
		
	}

	/*
	 * ����������
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
	 * ���������񣨷ǵݹ飩
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
			TreeNode tmpTree = stack.firstElement() ; // ջ���ڵ�
			stack.pop() ; // ջ���ڵ��ջ
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
