package muyanmoyang.swadoffer;

/**
 *  ì³²¨À­ÆõÊýÁÐ
 * @author hadoop
 *
 */ 
public class Fibonacci {
	public static void main(String[] args) {
		Fibonacci f = new Fibonacci() ;
		System.out.println(f.Fibonacci(5)) ;
	}
	public int Fibonacci(int n) {
		int result[] = {0,1} ;
        if(n<2){
        	return n ;
        }
        int fibnMinus1 = 1 ;
        int fibnMinus2 = 0 ;
        int fibn = 0 ;
        for(int i=2; i<=n ; i++){
        	fibn = fibnMinus1 + fibnMinus2 ;
        	fibnMinus2 = fibnMinus1 ;
        	fibnMinus1 = fibn ;
        }
		return fibn ;
    }
}
