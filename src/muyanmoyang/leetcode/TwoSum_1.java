package muyanmoyang.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, return indices of the two numbers 
 * such that they add up to a specific target.
 * @author hadoop
 *
 */
public class TwoSum_1 {
	public static void main(String[] args) {
		TwoSum_1 t = new TwoSum_1() ;
		int num[] = {0,4,3,0} ; 
		int[] res = t.twoSum2(num, 0) ;
		for(int elem : res){
			System.out.print(elem + "¡¢") ;
		}
	}
	public int[] twoSum(int[] nums, int target) {
		if(nums==null || nums.length == 0){
			return null ;
		}
		int[] result = new int[2];
		for(int i=0; i<nums.length; i++){
			for(int j=i+1; j<nums.length; j++){
				if(nums[i] + nums[j] == target){
					result[0] = i ;
					result[1] = j ;
				}
			}
		}
		return result;
	}
	
	public int[] twoSum2(int[] nums, int target) {
		if(nums==null || nums.length == 0){
			return null ;
		}
		Map<Integer,Integer> map = new HashMap<Integer,Integer>() ;
		int[] result = new int[2];
		for(int i=0; i<nums.length; i++){
			if(map.containsKey(target-nums[i])){
				result[0] = map.get(target-nums[i]) ;
				result[1] = i ;
			}
			map.put(nums[i],i) ;
		}
		return result;
	}
}
