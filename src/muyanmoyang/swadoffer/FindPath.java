package muyanmoyang.swadoffer;

import java.util.ArrayList;
import java.util.Stack;

/**
 *  ����һ�Ŷ�������һ����������ӡ���������н��ֵ�ĺ�Ϊ��������������·����
 *  ·������Ϊ�����ĸ���㿪ʼ����һֱ��Ҷ����������Ľ���γ�һ��·����
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
	 * �ݹ����
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
