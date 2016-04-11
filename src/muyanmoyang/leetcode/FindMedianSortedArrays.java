package muyanmoyang.leetcode;

/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively. 
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * @author hadoop
 *  
 *  采用分治法
 *
 */
public class FindMedianSortedArrays {
	public static void main(String[] args) {
		int[] nums1 = {2} ;
		int[] nums2 = {1,3,4} ;
		FindMedianSortedArrays f = new FindMedianSortedArrays() ;
		System.out.println(f.findMedianSortedArrays(nums1, nums2)) ;
	}
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		double mid1 ; // num1的中位数
		double mid2 ; // num2的中位数
		if(nums1.length <= 0 && nums2.length <=0){
			return -1 ;
		}
		if((nums1.length==0 && nums2.length >0)){
			if(nums2.length % 2 == 0)
				return (nums2[nums2.length/2-1]+nums2[nums2.length/2]) / 2.0 ;
			else
				return nums2[nums2.length/2] ;
		}
		if((nums2.length==0 && nums1.length >0)){
			if(nums1.length % 2 == 0)
				return (nums1[nums1.length/2-1]+nums1[nums1.length/2]) / 2.0 ;
			else
				return nums1[nums1.length/2] ;
		}
		if(nums1.length == 1 && nums2.length ==1){
			return (nums1[0] + nums2[0]) / 2.0 ;
		}
		if(nums1.length % 2 == 1){
			mid1 = nums1[nums1.length/2] ;
		}else{
			mid1 = ((nums1[nums1.length/2-1]+nums1[nums1.length/2]) / 2.0) ;
		}
		if(nums2.length % 2 == 1){
			mid2 = nums2[nums2.length/2] ;
		}else{
			mid2 = ((nums2[nums2.length/2-1]+nums2[nums2.length/2]) / 2.0) ;
		}
		if(nums1.length == 2 && nums2.length == 2){
			return (Math.max(nums1[0],nums2[0]) + Math.min(nums1[1],nums2[1])) / 2.0 ; 
		}
		if(mid1 == mid2){
			return mid1 ;
		}else{
			if(mid1 < mid2){
				System.out.println("m1=" + mid1 + "    m2=" + mid2);
				int[] array1 = reconstructArray(nums1,false) ;
				int[] array2 = reconstructArray(nums2,true) ;
				return findMedianSortedArrays(array1, array2) ;
			}else{
				System.out.println("m1=" + mid1 + "    m2=" + mid2);
				int[] array1 = reconstructArray(nums1,true) ;
				int[] array2 = reconstructArray(nums2,false) ;
				return findMedianSortedArrays(array1, array2) ;
			}
		}
    }

	private int[] reconstructArray(int[] nums, boolean flag) {
		int result[] = null ; 
		if(nums.length %2 == 0){
			result = new int[nums.length/2] ;
			if(!flag){
				for(int i=0 ;i<result.length; i++){
					result[i] = nums[i+(result.length)] ;
					System.out.print(result[i] + "、") ;
				}
				System.out.println();
			}else{
				for(int i=0 ;i<result.length; i++){
					result[i] = nums[i] ; 
					System.out.print(result[i] + "、") ;
				}
				System.out.println();
			}
		}
		if(nums.length %2 == 1){
			result = new int[nums.length/2+1] ;
			if(!flag){
				for(int i=0 ;i<result.length; i++){
					result[i] = nums[i+(result.length-1)] ;
					System.out.print(result[i] + "、") ;
				}
				System.out.println();
			}else{
				for(int i=0 ;i<result.length; i++){
					result[i] = nums[i] ;
					System.out.print(result[i] + "、") ;
				}
				System.out.println();
			}
		}
		return result ;
	}
}
