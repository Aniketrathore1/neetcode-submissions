class Solution {
    int[][] memo;
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        memo = new int[m][n];

        for(int i =  0 ; i < m ; i++){
            Arrays.fill(memo[i] , -1);
        }
        return solve(0 , 0 , grid);
    }

    private int solve(int i , int j , int[][] grid){
        int m = grid.length;
        int n = grid[0].length;
        if(i >= m || j >= n) return Integer.MAX_VALUE;

        if(i == m -1 && j == n-1) return grid[i][j];
        if(memo[i][j] != -1) return memo[i][j];

        int down = solve(i+1 , j ,  grid);
        int right = solve(i , j + 1 , grid);

        return memo[i][j] = grid[i][j] + Math.min(down , right);
    }
}