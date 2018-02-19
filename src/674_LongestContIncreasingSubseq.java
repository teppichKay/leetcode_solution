// Given an unsorted array of integers, find the length of longest continuous increasing subsequence (subarray).
// Example 1:
// Input: [1,3,5,4,7]
// Output: 3
// Explanation: The longest continuous increasing subsequence is [1,3,5], its length is 3.
// Even though [1,3,5,7] is also an increasing subsequence, it's not a continuous one where 5 and 7 are separated by 4.

// Time complexity: O(n)    Space: O(1)

class Solution {
  public int findLengthOfLCIS(int[] nums) {
    int res = 0;
    int tmp = 1;
    if (nums.length == 0 || nums == null) return 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i+1] > nums[i]) {
        tmp++;
        res = Math.max(tmp, res);
      } else {
        tmp = 1;
      }
    }
    return Math.max(tmp, res);
  }
}
