class Solution {
    int memo[];
    public int minCostClimbingStairs(int[] cost) {
        memo = new int[cost.length];
        Arrays.fill(memo , -1);
        return Math.min(solve(0 , cost) , solve(1 , cost));
    }

    private int solve(int i  , int[] cost){
        if(i >= cost.length){
            return 0;
        }

        if(memo[i] != -1) return memo[i];

        int onestep = solve(i+1 , cost);
        int twostep = solve(i+2 , cost);
        return memo[i] = cost[i] + Math.min(onestep , twostep);
    }
}
