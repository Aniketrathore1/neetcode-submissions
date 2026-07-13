class Solution {
    int[][] memo;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        memo = new int[m][n];


        for(int i = 0 ; i < m ; i++){
            Arrays.fill(memo[i] , -1);
        }

        return solve(0 , 0 , obstacleGrid);
    }

    private int solve(int i  , int j  , int[][] grid){
        int m = grid.length;
        int n = grid[0].length;

        if(i >= m || j >= n){
            return 0;
        }

        if(grid[i][j] == 1) return 0;
        if(i == m-1 && j == n-1) return 1;
        

        if(memo[i][j] != -1) return memo[i][j];

        int down = solve(i+1 , j , grid);
        int right = solve(i , j+1 , grid);

        return memo[i][j] = down+right;
    }
}