package muyanmoyang.sort;

public class SingleSelectSort {
	
	public static void main(String[] args) {
		int[] data = OriginalData.generateData() ;
		OriginalData.show(data);
		selectSort(data) ;
		OriginalData.show(data); 
	}
	private static void selectSort(int[] data) {
		int min ;
		for(int i=0; i<data.length; i++){
			min = i ;
			for(int j=i+1; j<data.length; j++){
				if(data[min] > data[j])
				{
					min = j ;
				}
			}
			if(i != min){
				OriginalData.swap(data, i, min) ;
			}
		}
	}
}
