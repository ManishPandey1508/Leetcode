package leetcode.DFS;

public class FrindCircles {

	public static void main(String[] args) {
		
		int[][] matrix = {{1,0,0},{0,1,1},{0,1,1}};
		
		int result = new FrindCircles().new Solution().findCircleNum(matrix);
		
		System.out.println("Result" + result);
	}

	public class Solution {
	    public int findCircleNum(int[][] M) {
	        //DFS Solution 
	        boolean[] visited = new boolean[M.length];
	        int count = 0;
	        for(int i = 0; i < M.length; i++) 
	            if(!visited[i]) {
	                dfs(M, visited, i);
	                count++;
	            }
	        return count;
	    }
	    private void dfs(int[][] M, boolean[] visited, int i) {
	        for(int j = 0; j < M.length; j++) 
	            if(M[i][j] == 1 && !visited[j]) {
	                visited[j] = true;
	                dfs(M, visited, j);
	            }
	    }
	}
	
}


