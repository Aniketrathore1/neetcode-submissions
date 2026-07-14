class Solution {
    int[] memo;
    public int tribonacci(int n) {
        memo = new int[n+1];
        Arrays.fill(memo , -1);
        return solve(n);
    }

    private int solve(int n){
        if(n == 0) return 0;

        if(n == 1 || n == 2) return 1;

        if(memo[n] != -1){
            return memo[n];
        }

        return memo[n] = solve(n-1) + solve(n-2) + solve(n-3);
    }
}