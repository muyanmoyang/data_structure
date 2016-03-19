package muyanmoyang.swadoffer;

/**
 * ÖØ½¨¶þ²æÊ÷
 * @author hadoop
 *
 */

public class RebuildTree{
	public static void main(String[] args) {
		
	}
	public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
       TreeNode root=reConstructBinaryTree(pre,0,pre.length-1,in,0,in.length-1);
       return root;
   }
	private TreeNode reConstructBinaryTree(int[] pre, int preStart, int preEnd, int[] in,int inStart, int inEnd) {
		if(preStart > preEnd || inStart > inEnd){
			return null;
		}
		TreeNode root = new TreeNode(pre[preStart]) ;
		for(int i=inStart; i<= inEnd; i++){
			if(in[i] == pre[preStart]){
				root.left = reConstructBinaryTree(pre, preStart+1, preStart+i-inStart, in, inStart, i-1) ;
				root.right = reConstructBinaryTree(pre, i-inStart+preStart+1,preEnd,in, i+1, inEnd) ;
			}
		}
		return root;
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}
