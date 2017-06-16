package leetcode.arrays;

public class BuildTreeINPost {

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static void main(String[] args) {

		int in[] = { 4, 8, 2, 5, 1, 6, 3, 7 };
		int post[] = { 8, 4, 5, 2, 6, 7, 3, 1 };

		TreeNode root = new BuildTreeINPost().new Solution().buildTree(in, post);
		preOrder(root);

	}

	/* This funtcion is here just to test */
	public static void preOrder(TreeNode node) {
		if (node == null)
			return;
		System.out.print(node.val + " ");
		preOrder(node.left);
		preOrder(node.right);
	}

	class Solution {
		int postIndex = 0;
		
	 class index{
		 int index;
	 }

		public TreeNode buildTree(int[] inorder, int[] postorder) {
			index index = new index();
			index.index = postorder.length-1;
			
			TreeNode root = constructTree(inorder, postorder, 0, inorder.length - 1,index);
			return root;
		}

		public TreeNode constructTree(int[] inorder, int[] postOrder, int inStart, int inEnd,index index) {

			if (inStart > inEnd)
				return null;
			
			TreeNode root = new TreeNode(postOrder[index.index]);
			index.index--;
			System.out.println("Root "+ root.val);
			
			int rootIndex = search(inorder, inStart, inEnd, root.val);
			
			if (inStart == inEnd)
				return root;
			root.right = constructTree(inorder, postOrder, rootIndex + 1, inEnd,index);

			root.left = constructTree(inorder, postOrder, inStart, rootIndex - 1,index);
			
			
			
			return root;

		}

		public int search(int[] in, int instart, int inEnd, int val) {
			int i ;
			for (i = instart; i <= inEnd; i++) {
				if (in[i] == val) {
					break;
				}
			}
			return i;
		}

	}
}
