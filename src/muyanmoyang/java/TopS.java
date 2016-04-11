package muyanmoyang.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TopS {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line ;
		int testNum = Integer.parseInt(br.readLine()) ;
		System.out.println("testNum=" + testNum) ;
		int count = 0 ;
		while ((line=br.readLine()) != null) {
			count ++ ;
			int N = Integer.parseInt(line.split(" ")[0]);// N篇文章
//			System.out.println("N=" + N);
			int P = Integer.parseInt(line.split(" ")[1]);// 页数阈值P
			int W = Integer.parseInt(line.split(" ")[2]);// 每页的宽度W
			int H = Integer.parseInt(line.split(" ")[3]);// 每页的高度H
			int[] a = new int[N] ;
			String str = br.readLine() ;
			for(int i=0; i<N; i++){
				a[i] = Integer.parseInt(str.split(" ")[i]) ;
			}
			
			int S = 1 ; // 字体的最大边长
			if(N >=1 && N <= 1000 && W >=1 && W <= 1000 && H >=1 && H <= 1000 && P >=1 && P <= 1000000){
				int sum = 0,elem = 0 ;
				for(int i=0; i<a.length; i++){
					sum += (a[i]) ;
				}
				while(true){
					if(H/S>0 && W/S >0){
						elem = ((int)H/S * (int)W/S) ;
					}else{
						if(H/S>0 && W/S==0){
							elem = H/S ;
						}else{
							elem = W/S ;
						}
					}
					System.out.println("Math.min(W,H)=" + Math.min(W,H)) ;
					if((sum/elem)<P && S < Math.min(W,H)){
						S ++ ;
					}else{
						break ;
					}
				}
			}
			System.out.println("S的值:" + S) ;
			if(count == testNum){
				break ;
			}
		}
		br.close();
	}
}