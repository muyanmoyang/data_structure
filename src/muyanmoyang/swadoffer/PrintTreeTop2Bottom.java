package muyanmoyang.swadoffer;

import java.util.ArrayList;

/**
 *  从上往下打印二叉树
 * @author hadoop
 *
 */
public class PrintTreeTop2Bottom {
	public static void main(String[] args) {
		
	}
	
	public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
		ArrayList<TreeNode> list = new ArrayList<TreeNode>() ;
		ArrayList<Integer> result = new ArrayList<Integer>() ;
        if(root==null){
        	return result ;
        }
        list.add(root) ;
        while(!list.isEmpty()){
        	TreeNode node = list.remove(0) ;
        	result.add(node.val) ;
        	if(node.left!=null){
        		list.add(node.left) ;
        	}
        	if(node.right!=null){
        		list.add(node.right) ;
        	}
        }
		return result ;
    }
}
