package muyanmoyang.data.BTree;

import java.util.Stack;

/**
 * 二叉树的遍历,前中后序遍历的递归和非递归实现
 * 
 * @author
 * 
 */
public class TraverseTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Node node = initTree();
		System.out.println("先序遍历递归实现");
		preOrderTraverse(node);
		System.out.println("\n 先序遍历非递归实现");
		preOrderTraverse2(node);
		System.out.println("\n 中序遍历非递归实现");
		inOrderTraverse(node);
		System.out.println("\n 后序遍历非递归实现--双栈法");
		postOrderTraverse(node);
	}

	private static Node initTree() {
		Node aNode = new Node("a", null, null);
		Node bNode = new Node("b", null, null);
		Node cNode = new Node("c", null, null);
		Node dNode = new Node("d", null, null);
		Node eNode = new Node("e", null, null);
		Node fNode = new Node("f", null, null);
		Node deleteNode = new Node("-", cNode, dNode);
		Node multiNode = new Node("*", bNode, deleteNode);
		Node addNode = new Node("+", aNode, multiNode);
		Node divNode = new Node("/", eNode, fNode);
		Node deleteNode2 = new Node("-", addNode, divNode);
		return deleteNode2;
	}

	/**
	 * 先序遍历（递归实现）
	 * 
	 * @param node
	 *            根节点
	 */
	public static void preOrderTraverse(Node node) {
		if (node == null)
			return;
		System.out.print(node.key); // 先打印出父节点,这一行代码位置的不同，决定了是哪种遍历方法
		if (node.left != null) // 访问左子节点
			preOrderTraverse(node.left);
		if (node.right != null)
			preOrderTraverse(node.right);
	}

	/**
	 * 先序遍历（非递归实现）
	 * 
	 * @param node
	 */
	public static void preOrderTraverse2(Node node) {
		if (node == null)
			return;
		Stack<Node> stack = new Stack<Node>(); // 建立一个stack用来存放左子节点
		Node p = node; // p相当于一个指针
		while (p != null || !stack.isEmpty()) {
			if (p != null) {
				System.out.print(p.key);
				stack.push(p);
				p = p.left;
			} else {
				p = stack.pop();
				p = p.right;
			}
		}
	}

	/**
	 * 中序遍历，非递归实现
	 * 
	 * @param node
	 */
	public static void inOrderTraverse(Node node) {
		if (node == null)
			return;
		Stack<Node> stack = new Stack<Node>(); // 建立一个stack用来存放左子节点
		Node p = node; // p相当于一个指针
		while (p != null || !stack.isEmpty()) {
			if (p != null) {
				stack.push(p); // 根节点进栈，访问左子节点
				p = p.left;
			} else { // 根节点出栈，访问右子节点
				p = stack.pop();
				System.out.print(p.key);
				p = p.right;
			}
		}
	}

	/**
	 * 后序遍历,双栈法
	 * 
	 * @param node
	 */
	public static void postOrderTraverse(Node node) {
		if (node == null)
			return;
		Stack<Node> stack = new Stack<Node>(); // 建立一个stack用来访问该树
		Stack<Node> out = new Stack<Node>(); // 该栈用于保存输出顺序
		Node p = node; // p相当于一个指针
		while (p != null || !stack.isEmpty()) {
			if (p != null) {
				stack.push(p);
				out.push(p);
				p = p.right;
			} else {
				p = stack.pop().left;
			}
		}// while
		while (!out.isEmpty()) {
			System.out.print(out.pop().key);
		}
	} // post
}
