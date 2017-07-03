/*Explanation
So assuming the sum of the array it SUM, so eventually player1 and player2 will split the SUM between themselves. For player1 to win, he/she has to get more than what player2 gets. If we think from the prospective of one player, then what he/she gains each time is a plus, while, what the other player gains each time is a minus. Eventually if player1 can have a >0 total, player1 can win.

Helper function simulate this process. In each round:
if e==s, there is no choice but have to select nums[s]
otherwise, this current player has 2 options:
--> nums[s]-helper(nums,s+1,e): this player select the front item, leaving the other player a choice from s+1 to e
--> nums[e]-helper(nums,s,e-1): this player select the tail item, leaving the other player a choice from s to e-1
Then take the max of these two options as this player's selection, return it.
*/
package leetcode.dynamicProgramming;

public class PredictWinner {

	public static void main(String[] args) {
		int[] nums ={1, 5, 2};
		boolean result = new PredictWinner().new Solution().PredictTheWinner(nums);
		System.out.println("Result "+ result);
	}
	
	class Solution {
	    public boolean PredictTheWinner(int[] nums) {
	        
	    	return helper(nums,0,nums.length-1,new int[nums.length][nums.length])>=0;
	    	
	    }
	    public int helper(int[] nums, int s, int e, int[][] mem){
	    	
	    	if(mem[s][e] ==0)
	    		mem[s][e]= s==e?nums[e]:Math.max(nums[s]-helper(nums,s+1,e,mem),nums[e]-helper(nums,s,e-1,mem)); 
	    	return mem[s][e];
	    	
	    	
	    }
	}
}
