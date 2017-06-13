/*Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.*/

package leetcode.arrays;

public class BuildTree {

	public static void main(String[] args) {

		int[] in = { 4, 2, 5, 1, 6, 7, 3, 8 };
		int[] pre = { 1, 2, 4, 5, 3, 7, 6, 8 };

		TreeNode tNode = new BuildTree().new Solution().buildTree(pre, in);
		printInorder(tNode);
	}

	public static void printInorder(TreeNode node) {
		if (node == null)
			return;

		/* first recur on left child */
		printInorder(node.left);

		/* then print the data of node */
		System.out.print(node.val + " ");

		/* now recur on right child */
		printInorder(node.right);
	}

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	class Solution {
		int preIndex = 0;

		public TreeNode buildTree(int[] preorder, int[] inorder) {

			TreeNode tNode;
			int inStart = 0;
			int inEnd = inorder.length - 1;
			tNode = constructTree(preorder, inorder, inStart, inEnd);
			return tNode;
		}

		public TreeNode constructTree(int[] pre, int[] in, int inStart, int inEnd) {

			if (inStart > inEnd)
				return null;
			
			TreeNode tNode = new TreeNode(pre[preIndex++]);

			if (inStart == inEnd)
				return tNode;

			int inIndex = search(in, inStart, inEnd, tNode.val);

			tNode.left = constructTree(pre, in, inStart, inIndex - 1);

			tNode.right = constructTree(pre, in, inIndex + 1, inEnd);

			return tNode;
		}

		public int search(int[] in, int inStart, int inEnd, int val) {
			int i;

			for (i = inStart; i <= inEnd; i++) {
				if (in[i] == val)
					return i;
			}
			return i;
		}

	}
}
