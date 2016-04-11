package muyanmoyang.swadoffer;

/**
 * ����ÿ������,��һ������������n(1��n<100000)��ʾ�����������a��ʾС�׵ĳ�ʼ����ֵ.
 *	�ڶ���n������,b1,b2...bn(1��bi��n)��ʾÿ������ķ�����
 *	
 *	��������Ĺ��������biС�ڵ���С�׵ĵ�ǰ����ֵc,��ô���������ɴ�ܹ���,�� ��ʹ���Լ�������ֵ����bi;
 *	���bi����c,����Ҳ�ܴ�ܹ���,����������ֵֻ������bi ��c�����Լ��.
 */
import java.util.Scanner;
/**
 *  С�״����Ϸ
 * @author hadoop
 *
 */
public class NetEaseMonster {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in) ;
		
		while(in.hasNext()){
			int numOfMon = in.nextInt() ;    // ��������
			int originalLife = in.nextInt() ;  // ��ʼ����ֵ
			int[] defence = new int[numOfMon] ;
			if(numOfMon<1 || numOfMon>=100000){
				System.exit(0);
			}
			
			for(int i=0; i<numOfMon; i++){   // ����ķ���ֵ
				defence[i] = in.nextInt() ;
				if(defence[i]<1 || defence[i]>=100000){
					System.exit(0);
				}
			}
			for(int i=0; i<numOfMon; i++){  //С�״����
				originalLife += netEaseFight(originalLife,defence[i]) ;
			}
			System.out.println(originalLife);
		}
		
	}
	/*
	 * ���
	 */
	private static int netEaseFight(int originalLife, int defence) {
		if(originalLife >= defence){
			return defence ; // С�״���˹��� 
		}else{
			return maxGCD(originalLife,defence) ;
		}
	}

	/*
	 *  �������������Լ��
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
