package leetcode.arrays;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentehis {

	public static void main(String[] args) {

		int n = 2;
		ArrayList<String> result = new GenerateParentehis().new Solution().generateParenthesis(n);
		
		System.out.println(result);
	}

	public class Solution {
	    public ArrayList<String> generateParenthesis(int n) {
	    	ArrayList<String> result = new ArrayList<String>();
	        
	        if( n == 1){
	            String s = "()";
	            result.add(s);
	        }else{
	            List<String> ss = generateParenthesis(n - 1);
	            for(String str: ss){
	            	result.add("("+str+")");
	            	result.add("()"+str);
	            }            
	        }
	        return result;
	    }
	}
	
}
