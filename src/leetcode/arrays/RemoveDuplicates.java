/*Given a sorted array, remove the duplicates in place such that each element appear only once and 
 * return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

For example,
Given input array nums = [1,1,2],

Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. 
.It doesn't matter what you leave beyond the new length.

*/


package leetcode.arrays;

public class RemoveDuplicates {

	public static void main(String[] args) {
	
		int[] nums = {1,1,2};
		
		System.out.println("Length after removing Duplicates" + new RemoveDuplicates().new Solution().removeDuplicates(nums));
		
	}
	
	// The tricky part is the Sorted array,if array is not sorted than we can not use the below logic, because 
	// in that case duplicates need not to be adjacent
	
	class Solution {
	    public int removeDuplicates(int[] nums) {	
	    	
	    	if(nums.length==0)
	    		return 0;
	    	int a = 0;
	    	nums[a] = nums[0];
	    	for (int i = 0; i < nums.length; i++) {
				
	    		if(nums[a]!=nums[i]){
	    			a++;
	    			nums[a] = nums[i];
	    		}
	    		
			}
	    	
	    	return a+1;
	    }
	}
	
	
}

