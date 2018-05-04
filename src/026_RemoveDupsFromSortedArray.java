// Given a sorted array, remove the duplicates in-place such that each element appear only once and return the new length.
//
// in-place
//
// Given nums = [1,1,2],
//
// Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
// It doesn't matter what you leave beyond the new length.

// Time complexity: O(n) Space : O(1)

class Solution {
  public int removeDuplicates(int[] nums) {
    if (nums == null || nums.length == 0) return 0;
    int i = 0;
    for (int j = 0; j < nums.length; j++) {
      if (nums[i] < nums[j]) {
        nums[++i] = nums[j];
      }
    }
    return ++i;
  }
}
