package leetcde.string;

public class CountAndSay {

	public static void main(String[] args) {
	int n =2;
	
	String res = new CountAndSay().new Solution().countAndSay(n);
	System.out.println("Result "+ res);
	}

	class Solution {
		public String countAndSay(int n) {
			String res = "";
			if (n==0 || n == 1)
				res = "1";
			else if (n == 2)
				res = "11";
			else {
				int start = 3;
				res = "11";
				while (start <= n) {
						
					int length = res.length();
					int j = 0;
					StringBuilder tempRes = new StringBuilder();
					while (j < length) {
						int freq=0;
						char a = res.charAt(j);
						while(j+freq< length && a==res.charAt(j+freq))
							freq++;
						tempRes.append(freq+""+a);
						j=j+freq;
					}
					res =tempRes.toString();
					System.out.println(res);
					start++;
				}
			
			}
			return res;
		}
	}

}
