class Solution {
    int[][] memo;
    public int uniquePaths(int m, int n) {
        memo = new int[m][n];

        for(int i = 0 ; i < m ; i++){
            Arrays.fill(memo[i] , -1);
        }

        return solve(0 , 0 , m , n);
    }

    private int solve(int i  ,int j  , int m  , int n){
        if(i >= m || j >=n) return 0;
        if( i ==  m-1 && j == n-1) return 1;

        if(memo[i][j] != -1){
            return memo[i][j];
        }

        int down = solve(i+1 , j , m , n);
        int right = solve(i , j + 1 , m , n);
        return memo[i][j] = down+right;
    }
}
