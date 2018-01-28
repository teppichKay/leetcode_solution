// For example, given array S = {-1 2 1 -4}, and target = 1.
// The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

// Time complexity: O(n^2) Space: O(1)

class Solution {
  public int threeSumClosest(int[] nums, int target) {
    int res = 0;
    int min_dif = Integer.MAX_VALUE;
    Arrays.sort(nums);
    for (int i = 0; i < nums.length - 2; i++) {
      int low = i + 1, high = nums.length - 1;
      while (low < high) {
        int sum = nums[i] + nums[low] + nums[high];
        int dif = Math.abs(sum - target);
        if (dif < min_dif) {
          res = sum;
          min_dif = dif;
        }
        if (sum < target) {
          low++;
        } else {
          high--;
        }
      }
    }
    return res;
  }
}
