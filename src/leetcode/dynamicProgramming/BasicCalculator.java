package leetcode.dynamicProgramming;

import java.util.Deque;
import java.util.LinkedList;

public class BasicCalculator {

	public static void main(String[] args) {
		
		String s = "1*2-3/4+5*6-7*8+9/10";
		
		int res = new BasicCalculator().new Solution().calculate(s);
		System.out.println("Result " + res);

	}

	class Solution {
		public int calculate(String s) {

			int num = 0;
			int n = s.length();
			char sign = '+';
			Deque<Integer> stack = new LinkedList<Integer>();

			for (int i = 0; i < n; i++) {

				if (Character.isDigit(s.charAt(i))) {
					 num = num*10+s.charAt(i)-'0';
				}
				if (!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ' || i == n - 1) {
					if (sign == '-') {
						stack.push(-num);
					}
					if (sign == '+') {
						stack.push(num);
					}
					if (sign == '*') {
						stack.push(stack.pop() * num);
					}
					if (sign == '/') {
						int p = stack.pop() / num;
						if(p!=0)
						stack.push(p);
					}
					sign = s.charAt(i);
					num = 0;
				}

			}
			int re=0;
			
		    for(int i:stack){
		        re += i;
		    }
		    return re;
		}
	}

}
