package leetcde.string;

public class AddBinaries {

	public static void main(String[] args) {

		String num1 = "111";
		String num2 = "1";
		String res = new AddBinaries().new Solution().addBinary(num1, num2);
		System.out.println("Result  "+ res);
		
	}

	class Solution {
		public String addBinary(String a, String b) {
			 StringBuilder sb = new StringBuilder();
		        int i = a.length() - 1, j = b.length() -1, carry = 0;
		        while (i >= 0 || j >= 0) {
		            int sum = carry;
		            if (j >= 0) sum += b.charAt(j--) - '0';
		            if (i >= 0) sum += a.charAt(i--) - '0';
		            sb.append(sum % 2);
		            carry = sum / 2;
		        }
		        if (carry != 0) sb.append(carry);
		        return sb.reverse().toString();
		}
	}

}
