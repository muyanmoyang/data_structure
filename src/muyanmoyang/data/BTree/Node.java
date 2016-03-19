package muyanmoyang.data.BTree;

/**
 * 节点
 * @author
 *
 */
public class Node {
	String key; //当前节点的键值
	Node left; //左右子节点
	Node right;
	public Node(String key, Node left, Node right) {
		this.key = key;
		this.left = left;
		this.right = right;
	}
}
