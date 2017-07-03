package leetcde.string;

import java.util.HashMap;
import java.util.Stack;

public class ValidParentheses {

	public static void main(String[] args) {
	
		
		String input = "([])";

		boolean response = new ValidParentheses().new Solution().isValid(input);
		
		System.out.println("Result "+ response);
	}

	class Solution {
	    public boolean isValid(String s) {
	        
	    	Stack<Character> stack = new Stack<>();
	    	HashMap<Character,Character> map = new HashMap<>();
	    	map.put('(',')' );
	    	map.put('{','}' );
	    	map.put('[',']' );
	    	
	    	if(s==null ||s.length()==0)
	    		return false;
	    	
	    	for (int i = 0; i < s.length(); i++) {
				if(map.containsKey(s.charAt(i))){
					stack.push(s.charAt(i));
				}
				else{
					if(stack.isEmpty())
						return false;
					if(!stack.isEmpty() && map.get(stack.peek())==s.charAt(i)){
						stack.pop();
						continue;
					}
						
					else{
						return false;
					}
				}
			}
	    	
	    	if(stack.isEmpty())
	    		return true;
	    	else 
	    		return false;	    	
	    }
	}
	
}
