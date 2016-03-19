package muyanmoyang.sort;

/**
 *  øÏÀŸ≈≈–Ú
 * @author hadoop
 *
 */
public class QuickSort {
	public static void main(String[] args) {
		int[] data = OriginalData.generateData() ;
		OriginalData.show(data);
		quickSort_4(data, 0, data.length-1) ;
		OriginalData.show(data); 
	}
	
	private static void quickSort_4(int[] data , int l, int r){
		int i = l, j = r ;
		int tmp ;
		if(l < r){
			tmp = data[l] ;
			while(i!=j){
				while(i<j && data[j] >tmp){
					-- j ;
				}
				if(i<j){
					data[i] = data[j] ;
					++ i ;
				}
				while(i<j && data[i]<tmp){
					++i ;
				}
				if(i<j){
					data[j] = data[i] ;
					--j ;
				}
			}
			data[i] = tmp ;
			quickSort(data, l, i-1) ;
			quickSort(data, i+1, r) ;
		}
	}
	
	private static void quickSort_3(int[] data , int l, int r){
		int temp ;
		int i=l, j=r ;
		if(l < r){
			temp = data[l] ;
			while(i != j){
				while(i < j && data[j] > temp) --j ;
				if(i < j){
					data[i] = data[j] ;
					++ i ;
				}
				while(i < j && data[i] < temp) ++ i ;
				if(i < j){
					data[j] = data[i] ;
					-- j ;
				}
			}
			data[i] = temp;
			quickSort(data, l, i-1) ;
			quickSort(data, i+1, r) ;
		}
	}
	
	
	private static void quickSort_2(int[] data ,int l , int r){
		int temp ;
		int i = l , j = r ;
		if(l < r){
			temp = data[l] ;
			while(i != j){
				while(i < j && data[j] > temp){
					--j ;
				}
				if(i < j){
					data[i] = data[j] ;
					++ i ;
				}
				while(i < j && data[i] < temp){
					++ i ;
				}
				if(i < j){
					data[j] = data[i] ;
					-- j ;
				}
			}
			data[i] = temp ;
			quickSort(data, l, i-1) ;
			quickSort(data, i+1, r) ;
		}
		
	}
	private static void quickSort(int[] data, int l, int r) {
		int temp ;
		int i = l , j = r ;
		if(l < r){
			temp = data[l] ;
			while(i != j){
				while(j>i && data[j] > temp){
					-- j ;
				}
				if(i < j){
					data[i] = data[j] ;
					++ i ;
				}
				while(i<j && data[i] < temp){
					++ i ;
				}
				if(i < j){
					data[j] = data[i] ;
					-- j ;
				}
			}
			data[i] =temp ;
			quickSort(data, l, i-1);
			quickSort(data, i+1, r);
		}
	}
}
