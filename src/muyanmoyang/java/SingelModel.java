package muyanmoyang.java;

/*
 *  ����ʽ(����ģʽ)
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
