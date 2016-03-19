package muyanmoyang.swadoffer;

/**
 *  求base的exponent次方
 * @author hadoop
 *
 */
public class DoublePower {
	public static void main(String[] args) {
		DoublePower dp = new DoublePower() ;
		System.out.println(dp.Power(10,2)) ;
	}
	
//	boolean invalidInput = false ;
	public double Power(double base, int exponent) {
		if(equal(base,0.0) && exponent < 0){
//			invalidInput = true ;
			return 0.0 ;
		}
		int absExponent = exponent ;
		if(exponent < 0){
			absExponent = -exponent ;
		}
		double result = PowerWithExponent(base,absExponent);
		if(exponent < 0){
			return 1.0 / result ;
		}
		return result;
	 }
//	private double PowerWithExponent(double base, int absExponent) {
//		double result = 1.0 ;
//		for(int i=0;i<absExponent;i++){
//			result = result * base ;
//		}
//		return result;
//	}
	private double PowerWithExponent(double base, int absExponent) {
		if(absExponent == 0){
			return 1 ;
		}
		if(absExponent == 1){
			return base ;
		}
		double result = Power(base, absExponent >> 1) ;
		result *= result ;
		if((absExponent % 2) == 1){
			result *= base ;
		}
		return result;
	}
	private boolean equal(double base, double d) {
		if((base-d > -0.0000001) && (base-d < 0.0000001)){
			return true ;
		}
		return false;
	}
}
