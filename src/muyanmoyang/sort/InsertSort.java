package muyanmoyang.sort;

public class InsertSort {
	public static void main(String[] args) {
		int[] data = OriginalData.generateData() ;
		OriginalData.show(data);
		insertSort(data) ;
		OriginalData.show(data); 
	}
	/*
	 *  ≤Â»Î≈≈–Ú
	 */
	private static void insertSort(int[] data) {
		for(int i=1; i<data.length; i++){
			for(int j=i; j>0 && less(data[j],data[j-1]); j--){
				OriginalData.swap(data, j-1, j) ;
			}
		}
	}
	private static boolean less(int i, int j) {
		return i < j;
	}
}
