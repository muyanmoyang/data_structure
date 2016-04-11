package muyanmoyang.swadoffer;

import java.util.Scanner;

public class NetEaseTest {

	public static int hurt = 0 ;
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		double R = scanner.nextInt();
		double x1 = scanner.nextInt();
		double y1 = scanner.nextInt();
		double x2 = scanner.nextInt();
		double y2 = scanner.nextInt();
		double x3 = scanner.nextInt();
		double y3 = scanner.nextInt();
		double x0 = scanner.nextInt();
		double y0 = scanner.nextInt();
		
		hurt(x1,y1,x0,y0,R);
		hurt(x2,y2,x0,y0,R);
		hurt(x3,y3,x0,y0,R);
		System.out.println(hurt);
	}

	private static int hurt(double x, double y, double x0, double y0,double r) {
		if((Math.sqrt(Math.pow(x-x0,2) + Math.pow(y-x0,2))) <= r){
			hurt ++ ;
		}
		return hurt ;
	}
}
