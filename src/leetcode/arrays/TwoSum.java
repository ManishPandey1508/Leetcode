/*Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:
Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
*/

package leetcode.arrays;

import java.util.HashMap;

public class TwoSum {
	
public static void main(String[] args) {

	System.out.println("test");
	
	int[] input = {2,7,11,15};
	
	int result[] = new TwoSum().new Solution().twoSum(input, 9);
	if(result!=null){
		System.out.println("First Result");
		System.out.println(result[0]);
		System.out.println(result[1]);
	}else{
		System.out.println("Array doesnt contain sums");
	}
		
	int[] input1 = {3,2,4};
	result =  new TwoSum().new Solution().twoSum(input1, 6);
	if(result!=null){
		System.out.println("Second Result");
		System.out.println(result[0]);
		System.out.println(result[1]);
	}else{
		
		System.out.println("Array doesnt contain sums");
		
	}
}
class Solution {
    public int[] twoSum(int[] nums, int target) {
    	
    	HashMap<Integer,Integer> refMap = new HashMap<>();
    	for (int i = 0; i < nums.length; i++) {	
    		int compliment = target - nums[i];
    		if(refMap.containsKey(nums[i])){
    			return new int[]{(int)refMap.get(nums[i]),i};
    		}else{
    			refMap.put(compliment, i);
    		}
		}
    	return new int[]{};
    }
}
	
}


