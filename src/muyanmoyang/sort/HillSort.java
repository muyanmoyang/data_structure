package muyanmoyang.sort;

/**
 * Ï£¶ûÅÅĞò
 * @author hadoop
 *
 */
public class HillSort {
	public static void main(String[] args) {
		int[] data = OriginalData.generateData() ;
		OriginalData.show(data);
		hillSort(data) ;
		OriginalData.show(data); 
	}
	/*
	 *  Ï£¶ûÅÅĞò
	 */
	private static void hillSort(int[] data) {
		int increment = 1 ;
		while(increment < (data.length / 3)){
			increment = increment * 3 + 1 ; 
		}
		while(increment >= 1){
			for(int i = increment ; i< data.length ; i++){
				for(int j=i ; j >= increment && (data[j] < data[j-increment]); j-=increment){
					OriginalData.swap(data, j, j-increment);
				}
			}
			increment = increment / 3 ;
		}
	}
}
