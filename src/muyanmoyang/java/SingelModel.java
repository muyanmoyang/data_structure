package muyanmoyang.java;

/*
 *  懒汉式(单例模式)
 */
public class SingelModel {
	
	private SingelModel(){} ;
	private static SingelModel s = null ;
	public static SingelModel getInstance(){
		if(s == null){
			synchronized(SingelModel.class){
				if(s == null){
					s = new SingelModel() ;
				}
			}
		}
		return s ;
	}
}

class SingelModel2{
	private SingelModel2(){} ;
	private static SingelModel2 s = null ;
	public static SingelModel2 getInstance(){
		if(s == null){
			synchronized (s) {
				if(s == null){
					s = new SingelModel2() ;
				}
			}
		}
		return s;
	}
}
