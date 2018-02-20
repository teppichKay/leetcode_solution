// Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
//
// Example 1
//
// Input: [3,0,1]
// Output: 2
//
// Solution: Bit Manipulation
// Time complexity: O(n) Space complexity: O(1)

class Solution {
  public int missingNumber(int[] nums) {
    int res = nums.length;
    for (int i = 0; i < nums.length; i++) {
      res = res ^ i ^ nums[i];
    }
    return res;
  }
}
