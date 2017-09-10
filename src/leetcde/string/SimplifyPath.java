/*Given an absolute path for a file (Unix-style), simplify it.

For example,
path = "/home/", => "/home"
path = "/a/./b/../../c/", => "/c"
click to show corner cases.

Corner Cases:
Did you consider the case where path = "/../"?
In this case, you should return "/".
Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
In this case, you should ignore redundant slashes and return "/home/foo".*/

package leetcde.string;

import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.Stack;

public class SimplifyPath {

	public static void main(String[] args) {

		// String input = "/a/./b/../../c/";
		// String input = "/../";
		String input = "/...";
		String res = new SimplifyPath().new Solution().simplifyPath(input);
		System.out.println("Result " + res);

	}

	class Solution {
		public String simplifyPath(String path) {

			Deque<String> stack = new LinkedList<String>();
			Set<String> skip = new HashSet<>(Arrays.asList("..", ".", ""));

			String[] dirs = path.split("/");

			for (String dir : dirs) {
				if (!stack.isEmpty() && dir.equals(".."))
					stack.pop();
				else if (!skip.contains(dir))
					stack.push(dir);
			}

			String res = "";
			for (String dir : stack)
				res = "/" + dir + res;
			return res.isEmpty() ? "/" : res;

		}

	}

}
