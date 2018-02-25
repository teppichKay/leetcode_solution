// Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.
//
// For example, given the array [2,3,1,2,4,3] and s = 7,
// the subarray [4,3] has the minimal length under the problem constraint.

// Solution 1: about O(n), O(1)
class Solution {
  public int minSubArrayLen(int s, int[] nums) {
    if (nums == null || nums.length == 0) return 0;
    int left = 0, right = 0, sum = 0, minLen = Integer.MAX_VALUE;

    while (right <= nums.length && left <= right) {
      if (sum < s) {
        if (right < nums.length) sum += nums[right++];
      } else {
        minLen = Math.min(minLen, right - left);
        sum -= nums[left++];
      }
    }
    return minLen == Integer.MAX_VALUE ? 0 : minLen;
  }
}

// Solution 2 : O(nlogn) Binary search. TBD
