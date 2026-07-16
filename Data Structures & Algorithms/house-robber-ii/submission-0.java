

class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        if (n == 1) {
            return nums[0];
        }

        return Math.max(
            robRange(nums, 0, n - 2),
            robRange(nums, 1, n - 1)
        );
    }

    private int robRange(int[] nums, int start, int end) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return solve(start, end, nums, dp);
    }

    private int solve(int index, int end, int[] nums, int[] dp) {
        if (index > end) {
            return 0;
        }

        if (dp[index] != -1) {
            return dp[index];
        }

        int rob = nums[index] + solve(index + 2, end, nums, dp);
        int skip = solve(index + 1, end, nums, dp);

        return dp[index] = Math.max(rob, skip);
    }
}