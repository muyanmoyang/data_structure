package muyanmoyang.swadoffer;

/**
 * Сv������n�ſΣ�ÿ�Ŷ��п��ԣ�Ϊ���õ���ѧ��Сv�������Լ���ƽ���ɼ�����Ϊavg��ÿ�ſ���ƽʱ�ɼ��Ϳ��Գɼ���ɣ�����Ϊr��
 * ������֪��ÿ�ſε�ƽʱ�ɼ�Ϊai ,���������ſεĿ��Գɼ�����һ�ֵĻ���СvҪ��bi ��ʱ�临ϰ������ϰ�Ļ���Ȼ����0�֡�
 * ͬʱ������Ȼ���Է��ָ�ϰ���ٶ�Ҳ�����õ��������ֵķ�����Ϊ���õ���ѧ��Сv����Ҫ������ʱ�临ϰ��
 *	
 * n���ڵ���1С�ڵ���1e5��r���ڵ���1С�ڵ���1e9,avg���ڵ���1С�ڵ���1e6)��������n�У�ÿ����������ai��bi����С�ڵ���1e6���ڵ���1
 */
import java.util.Scanner;

/**
 *  ���ס�����ѧ������
 * @author hadoop
 *
 */
public class NetEaseReward {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in) ;
		while(in.hasNext()){
			int n = in.nextInt() ; // �γ���
			long r = in.nextLong() ; // �γ�����
			long avg = in.nextLong() ;// �ý�ѧ�����ٵ�ƽ����
			long a[] = new long[n] ;
			long b[] = new long[n] ;
			
			long sum = r * n ; // ���пγ̵��ܷ�
			long satisfy = avg * n ; // �ý�ѧ����Ҫ���ܷ���
			long minhour = Integer.MAX_VALUE;
            int minIndex = -1;
            long study = 0;
			for(int i=0;i<n;i++){
				a[i] = in.nextLong() ; // ĿǰС�׸��ſε�ƽʱ��
				b[i] = in.nextLong() ; // �ÿγ�Ҫ���һ�ֱ��뻨�ĸ�ϰʱ��
				satisfy -= a[i] ;
				if(b[i] < minhour){
					minhour = b[i] ; //ѧϰ�ɱ���С��ʱ��
					minIndex = i ;  // ѧϰ�ɱ���С�Ŀγ̱��
				}
			}
			while(satisfy > 0){
				while(satisfy >0 && a[minIndex] < r){
					satisfy -- ;
					a[minIndex] ++ ;
					study += minhour ;
					if(satisfy<=0){
						break ;
					}
				}
				if(satisfy<=0) break;
                b[minIndex] = Integer.MAX_VALUE;
				minhour = Integer.MAX_VALUE;
	            minIndex = -1;
				for(int i=0;i<n;i++){
					
					if(b[i] < minhour){
						minhour = b[i] ; //ѧϰ�ɱ���С��ʱ��
						minIndex = i ;  // ѧϰ�ɱ���С�Ŀγ̱��
					}
				}
			}
			System.out.println(study);
		}
	}
}
