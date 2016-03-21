package muyanmoyang.swadoffer;

import javax.naming.spi.DirStateFactory.Result;

/**
 *  判断B树是不是A树的子结构
 * @author hadoop
 *
 */
public class HasSubTree {
	public static void main(String[] args) {
		
	}
	public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        boolean find = false ;
        if(root1!=null && root2!=null){
        	if(root1.val == root2.val){
        		find = doesTree1HaveTree2(root1, root2) ;
        	}
        	if(!find){
        		find = HasSubtree(root1.left, root2) ;
        	}
        	if(!find){
        		find = HasSubtree(root1.right, root2) ;
        	}
        }
		return find ;
    }
	/*
	 *  判断root1树中是否包含有root2树
	 */
	private boolean doesTree1HaveTree2(TreeNode root1, TreeNode root2) {
		if(root2 == null){
			return true ;
		}
		if(root1 == null){
			return false ;
		}
		if(root1.val != root2.val){
			return false ;
		}
		return doesTree1HaveTree2(root1.left, root2.left) && doesTree1HaveTree2(root1.right, root2.right) ;
	}
}
