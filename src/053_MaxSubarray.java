// Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
//
// For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
// the contiguous subarray [4,-1,2,1] has the largest sum = 6.
//
// Dynamic programming:
// there are two states for each element in the array: join in the contiguous subarray or start a new subarray.
// dp[i] = max{dp[i-1]+nums[i], nums[i]}
//
// The other variable can store the global maximum sum value by max{dp[i]}
//
// Time complexity: O(n)  Space: O(1)

class Solution {
  public int maxSubArray(int[] nums) {
    int local = nums[0];
    int global = nums[0];
    for (int i = 1; i < nums.length; i++) {
      local = Math.max(local + nums[i], nums[i]);
      global = Math.max(global, local);
    }
    return global;
  }
}
