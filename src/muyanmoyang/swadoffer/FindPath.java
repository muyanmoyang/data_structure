package muyanmoyang.swadoffer;

import java.util.ArrayList;
import java.util.Stack;

/**
 *  输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 *  路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * @author hadoop
 *
 */
public class FindPath {
	public static void main(String[] args) {
		
	}
	public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>() ;
		Stack<TreeNode> stack = new Stack<TreeNode>() ;
		if(root==null){
			return result ;
		}
		FindPath(root, target,stack,result) ;
		return result ;
    }
	/*
	 * 递归查找
	 */
	private void FindPath(TreeNode root, 
			int target, 
			Stack<TreeNode> stack,
			ArrayList<ArrayList<Integer>> result) {
		ArrayList<Integer> list = new ArrayList<Integer>() ;
		if(root == null){
			return ;
		}
		if(root.left==null && root.right==null){
			if(root.val == target){
				for(TreeNode elem : stack){
					list.add(elem.val) ;
				}
				list.add(root.val) ;
				result.add(list); 
			}
		}else{
			stack.push(root) ;
			FindPath(root.left, target-root.val, stack, result);
			FindPath(root.right, target-root.val, stack, result);
			stack.pop() ;
		}
		
	}
}
