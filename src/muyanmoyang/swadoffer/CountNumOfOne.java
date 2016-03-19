package muyanmoyang.swadoffer;

/**
 * 统计一个数n的二进制中1的个数
 * 
 * @author hadoop
 * 
 */
public class CountNumOfOne {
	public static void main(String[] args) {
		CountNumOfOne c = new CountNumOfOne();
		System.out.println(c.NumberOf1(14));
		
		System.out.println(c.ifPowerOf2(32)) ; //  判断一个整数是否是2的整数次幂  
		System.out.println(c.computeNumberOfMove(4,10)) ; // 判断一个证书n1的二进制经过多少次改变才能变成n2
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
	 *  判断一个整数是否是2的整数次幂  （ 将该整数减去1之后再和它自己做与运算，整数中唯一的1就会变为0）
	 */
	public boolean ifPowerOf2(int n){
		int flag =  (n-1) & n ;
		if(flag == 0){
			return true ;
		}
		return false ;
	}
	/*
	 *  判断一个证书n1的二进制经过多少次改变才能变成n2
	 */
	public int computeNumberOfMove(int n1, int n2){
		int xor = n1 ^ n2 ;
		System.out.println("异或：" + xor);
		
		int count = 0 ;
		while(xor!=0){
			 ++ count ;
			 xor = (xor-1) & xor ;
		}
		return count ;
	}
}
