package leetcde.string;

import java.util.Arrays;

public class NextGreaterElement {

	public static void main(String[] args) {
		
		int result = new NextGreaterElement().new Solution().nextGreaterElement(2136592);
		
		System.out.println("Result " +result);
		

	}

class Solution{
	
	public int nextGreaterElement(int n) {
	    char[] num = (n + "").toCharArray();
	    for(int i = num.length-2; i >= 0; i--) {
	        // find min number greater than num(i)
	        int minIdx = i;
	        for(int j = i+1; j < num.length; j++) {
	            minIdx = num[j] > num[i] ? j : minIdx;
	        }
	        if(minIdx != i) {
	            char temp = num[i]; //swap minIdx and i;
	            num[i] = num[minIdx];
	            num[minIdx] = temp;
	            
	            Arrays.sort(num, i+1, num.length);

	            long val = Long.parseLong(new String(num));
	            return (val <= Integer.MAX_VALUE) ? (int) val : -1;
	        }
	    }
	    return -1;
	}
	
	
}
	
	
}
