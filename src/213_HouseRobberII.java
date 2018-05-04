// dynamic programming. twice
// time: O(n)  Space: O(n)

class Solution {

    public int rob(int[] nums) {
        if (nums.length == 0 || nums == null) return 0;
        if (nums.length == 1) return nums[0];

        return Math.max(simpleRob(nums, 0, nums.length-2), simpleRob(nums, 1, nums.length-1));
    }

    public int simpleRob(int[] nums, int begin, int end) {
        int len = end-begin+1;
        if (len == 1) return nums[begin];

        int[] dp = new int[len];
        dp[0] = nums[begin];
        dp[1] = Math.max(nums[begin], nums[begin+1]);

        for (int i = 2; i < len; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[begin+i]);
        }
        return dp[len-1];
    }
}
