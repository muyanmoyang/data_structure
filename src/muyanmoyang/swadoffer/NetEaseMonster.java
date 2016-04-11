package muyanmoyang.swadoffer;

/**
 * 对于每组数据,第一行是两个整数n(1≤n<100000)表示怪物的数量和a表示小易的初始能力值.
 *	第二行n个整数,b1,b2...bn(1≤bi≤n)表示每个怪物的防御力
 *	
 *	如果遇到的怪物防御力bi小于等于小易的当前能力值c,那么他就能轻松打败怪物,并 且使得自己的能力值增加bi;
 *	如果bi大于c,那他也能打败怪物,但他的能力值只能增加bi 与c的最大公约数.
 */
import java.util.Scanner;
/**
 *  小易打怪游戏
 * @author hadoop
 *
 */
public class NetEaseMonster {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in) ;
		
		while(in.hasNext()){
			int numOfMon = in.nextInt() ;    // 怪物数量
			int originalLife = in.nextInt() ;  // 初始生命值
			int[] defence = new int[numOfMon] ;
			if(numOfMon<1 || numOfMon>=100000){
				System.exit(0);
			}
			
			for(int i=0; i<numOfMon; i++){   // 怪物的防御值
				defence[i] = in.nextInt() ;
				if(defence[i]<1 || defence[i]>=100000){
					System.exit(0);
				}
			}
			for(int i=0; i<numOfMon; i++){  //小易打怪物
				originalLife += netEaseFight(originalLife,defence[i]) ;
			}
			System.out.println(originalLife);
		}
		
	}
	/*
	 * 打怪
	 */
	private static int netEaseFight(int originalLife, int defence) {
		if(originalLife >= defence){
			return defence ; // 小易打败了怪物 
		}else{
			return maxGCD(originalLife,defence) ;
		}
	}

	/*
	 *  求两个数的最大公约数
	 */
	private static int maxGCD(int originalLife, int defence) {
		while(originalLife % defence != 0){
			int tmp = originalLife % defence ;
			originalLife = defence ;
			defence = tmp ;
		}
		return defence;
	}
}
