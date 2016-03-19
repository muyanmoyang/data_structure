package muyanmoyang.data.Btree2;

public class BtNode2 {
	int data ;
	BtNode2 lchild ;
	BtNode2 rchild ;
	public BtNode2(int data, BtNode2 lchild, BtNode2 rchild) {
		super();
		this.data = data;
		this.lchild = lchild;
		this.rchild = rchild;
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public BtNode2 getLchild() {
		return lchild;
	}
	public void setLchild(BtNode2 lchild) {
		this.lchild = lchild;
	}
	public BtNode2 getRchild() {
		return rchild;
	}
	public void setRchild(BtNode2 rchild) {
		this.rchild = rchild;
	}
	
}	
