package muyanmoyang.sort;

public class MergeSort {
	public static void main(String[] args) {
		int[] data = OriginalData.generateData() ;
		OriginalData.show(data);
		mergeSort(data, 0, data.length-1) ;
		OriginalData.show(data); 
	}
	private static void mergeSort(int[] data ,int start,int end) {
		if(!(start==end)){
			int mid = (start + end) / 2 ;
			mergeSort(data, start, mid);
			mergeSort(data, mid + 1, end);
			merge(data,start,mid,end) ;
		}
	}
	private static void merge(int[] data, int start, int mid, int end) {
		int tmp[] = new int[end-start+1] ;
		int i = start;
		int j = mid + 1;
		int k = 0 ;
		while(i<=mid && j<=end){
			if(data[i]>=data[j]){
				tmp[k++] = data[j++] ;
			}else{
				tmp[k++] = data[i++] ;
			}
		}
		while(i <= mid){
			tmp[k++] = data[i++] ;
		}
		while(j <= end){
			tmp[k++] = data[j++] ;
		}
		for(int m=0; m<k; m++){
			data[start+m] = tmp[m] ;
		}
		tmp = null ;
	}
}
