package leetcode.maths;

public class Palindrom {

	public static void main(String[] args) {
		
		boolean res = new Palindrom().new Solution().isPalindrome(1000000001);
		int[] in = {0,1,2,3,5,6,7,8,9};
		
		int result = new Palindrom().new Solution().missingNumber(in);
		System.out.println("Result "+ res);
		System.out.println("Result "+ result);
		
		
	}
	
	class Solution {
	    public boolean isPalindrome(int x) {
	        
	    	if(x<0)
	    		return false;
	    	int q = 0,p=x;
	    	
	    	while(p>=10){
	    		
	    		q *=10;
	    		q += p%10;
	    		
	    		p = p/10;
	    	}
	    	
	    	if(q == x/10 && p == x%10){
	    		return true;
	    	}
	    	
	    	return false;
	    	
	    	
	    }
	    
	    public int missingNumber(int[] nums) {
	     int sum = 0 ;
	     for(int i :nums){
	    	 sum+=i;
	     }
	    	int p = nums.length;
	     int sum2 = ( p* (p + 1)) / 2;
	     
	     
	    return  sum2 - sum;
	    	
	    }
	    
	}

}
