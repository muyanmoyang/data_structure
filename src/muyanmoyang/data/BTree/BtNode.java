package muyanmoyang.data.BTree;

/**
 * 二叉树的节点
 * @author hadoop
 *
 */
class BtNode {
	String data ;
	BtNode lchild ;
	BtNode rchild ;
	public BtNode(String data, BtNode lchild, BtNode rchild) {
		super();
		this.data = data;
		this.lchild = lchild;
		this.rchild = rchild;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public BtNode getLchild() {
		return lchild;
	}
	public void setLchild(BtNode lchild) {
		this.lchild = lchild;
	}
	public BtNode getRchild() {
		return rchild;
	}
	public void setRchild(BtNode rchild) {
		this.rchild = rchild;
	}
}
