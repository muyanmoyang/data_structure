package muyanmoyang.leetcode;

/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively. 
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * @author hadoop
 *  
 *  采用分治法
 *
 */
public class FindMedianSortedArrays_4 {
	public static void main(String[] args) {
		int[] nums1 = {3,100} ;
		int[] nums2 = {1,3,4} ;
		FindMedianSortedArrays_4 f = new FindMedianSortedArrays_4() ;
		System.out.println(f.findMedianSortedArrays(nums1, nums2)) ;
	}
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int[] result = new int[nums1.length + nums2.length] ;
		int x = 0 ;
		int i = 0;
		int j = 0;
		while(i < nums1.length && j < nums2.length){
			if(nums1[i] < nums2[j]){
				result[x++] = nums1[i++] ;
			}else{
				result[x++] = nums2[j++] ;
			}
		}
		while(i < nums1.length){
			result[x++] = nums1[i++] ;
		}
		while(j < nums2.length){
			result[x++] = nums2[j++] ;
		}
		return result.length % 2 ==0 ? ((result[result.length/2-1]+result[result.length/2])/2.0) 
					: result[result.length/2] ;
    }
}
