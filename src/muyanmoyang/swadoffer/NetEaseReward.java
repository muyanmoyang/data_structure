package muyanmoyang.swadoffer;

/**
 * 小v今年有n门课，每门都有考试，为了拿到奖学金，小v必须让自己的平均成绩至少为avg。每门课由平时成绩和考试成绩组成，满分为r。
 * 现在他知道每门课的平时成绩为ai ,若想让这门课的考试成绩多拿一分的话，小v要花bi 的时间复习，不复习的话当然就是0分。
 * 同时我们显然可以发现复习得再多也不会拿到超过满分的分数。为了拿到奖学金，小v至少要花多少时间复习。
 *	
 * n大于等于1小于等于1e5，r大于等于1小于等于1e9,avg大于等于1小于等于1e6)，接下来n行，每行两个整数ai和bi，均小于等于1e6大于等于1
 */
import java.util.Scanner;

/**
 *  网易——奖学金问题
 * @author hadoop
 *
 */
public class NetEaseReward {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in) ;
		while(in.hasNext()){
			int n = in.nextInt() ; // 课程数
			long r = in.nextLong() ; // 课程满分
			long avg = in.nextLong() ;// 拿奖学金最少的平均分
			long a[] = new long[n] ;
			long b[] = new long[n] ;
			
			long sum = r * n ; // 所有课程的总分
			long satisfy = avg * n ; // 拿奖学金需要的总分数
			long minhour = Integer.MAX_VALUE;
            int minIndex = -1;
            long study = 0;
			for(int i=0;i<n;i++){
				a[i] = in.nextLong() ; // 目前小易该门课的平时分
				b[i] = in.nextLong() ; // 该课程要想多一分必须花的复习时间
				satisfy -= a[i] ;
				if(b[i] < minhour){
					minhour = b[i] ; //学习成本最小的时间
					minIndex = i ;  // 学习成本最小的课程标号
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
						minhour = b[i] ; //学习成本最小的时间
						minIndex = i ;  // 学习成本最小的课程标号
					}
				}
			}
			System.out.println(study);
		}
	}
}
