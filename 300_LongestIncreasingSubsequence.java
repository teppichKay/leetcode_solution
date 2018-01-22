// dynamic programming
// Time complexity: O(n^2) Space complexity: O(n)
class Solution {
  public int lengthOfLIS(int[] nums) {
    // edge case
    if (nums == null || nums.length == 0) return 0;

    int[] cur = new int[nums.length];
    Arrays.fill(cur, 1);
    // base case
    int base = 1;

    for (int j = 1; j < nums.length ; j++ ) {
      for (int i = 0; i < j; i++) {
        if (nums[i] < nums[j]) {
          cur[j] = Math.max(cur[j], cur[i]+1);
        }
      }
      base = Math.max(base, cur[j]);
    }

    return base;
  }
}
