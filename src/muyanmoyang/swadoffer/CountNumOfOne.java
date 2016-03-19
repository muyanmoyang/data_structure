package muyanmoyang.swadoffer;

/**
 * ͳ��һ����n�Ķ�������1�ĸ���
 * 
 * @author hadoop
 * 
 */
public class CountNumOfOne {
	public static void main(String[] args) {
		CountNumOfOne c = new CountNumOfOne();
		System.out.println(c.NumberOf1(14));
		
		System.out.println(c.ifPowerOf2(32)) ; //  �ж�һ�������Ƿ���2����������  
		System.out.println(c.computeNumberOfMove(4,10)) ; // �ж�һ��֤��n1�Ķ����ƾ������ٴθı���ܱ��n2
	}

	public int NumberOf1(int n) {
		int count = 0;
		int flag = 1;
		while (flag != 0) {
			// System.out.println(":" + (binary & flag)) ;
			if ((n & flag) != 0) {
				count++;
			}
			flag = flag << 1;
		}

		return count;
	}
	/*
	 *  �ж�һ�������Ƿ���2����������  �� ����������ȥ1֮���ٺ����Լ��������㣬������Ψһ��1�ͻ��Ϊ0��
	 */
	public boolean ifPowerOf2(int n){
		int flag =  (n-1) & n ;
		if(flag == 0){
			return true ;
		}
		return false ;
	}
	/*
	 *  �ж�һ��֤��n1�Ķ����ƾ������ٴθı���ܱ��n2
	 */
	public int computeNumberOfMove(int n1, int n2){
		int xor = n1 ^ n2 ;
		System.out.println("���" + xor);
		
		int count = 0 ;
		while(xor!=0){
			 ++ count ;
			 xor = (xor-1) & xor ;
		}
		return count ;
	}
}
