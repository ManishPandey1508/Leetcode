/*79. Word Search
 * Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

For example,
Given board =

[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]
word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.
*/
package leetcode.arrays;

public class WordSearch {

	public static void main(String[] args) {

		char[][] board = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
		String word = "ABCCED";
		boolean res = new WordSearch().new Solution().exist(board, word);
		System.out.println("Word Found " + res);

	}

	class Solution {
		public boolean exist(char[][] board, String word) {

			boolean[][] isVisited = new boolean[board.length][board[0].length];

			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board[i].length; j++) {

					if (word.charAt(0) == board[i][j] && search(board, word, i, j, 0, isVisited))
						return true;
				}
			}
			return false;
		}

		public boolean search(char[][] board, String word, int i, int j, int index, boolean[][] isVisited) {

			if (index == word.length())
				return true;

			if (i >= board.length || i < 0 || j >= board[i].length || j < 0 || board[i][j] != word.charAt(index)
					|| isVisited[i][j])
				return false;

			isVisited[i][j] = true;

			if (search(board, word, i + 1, j, index + 1, isVisited)
					|| search(board, word, i - 1, j, index + 1, isVisited)
					|| search(board, word, i, j + 1, index + 1, isVisited)
					|| search(board, word, i, j - 1, index + 1, isVisited))
				return true;

			isVisited[i][j] = false;

			return false;
		}
	}
}
