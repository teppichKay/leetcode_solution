// Follow up for "Remove Duplicates":
// What if duplicates are allowed at most twice?
//
// For example,
// Given sorted array nums = [1,1,1,2,2,3],
//
// Your function should return length = 5,
// with the first five elements of nums being 1, 1, 2, 2 and 3.
// It doesn't matter what you leave beyond the new length.
//
// Time complexity: O(n) Space: O(1)

class Solution {
  public int removeDuplicates(int[] nums) {
    int len = nums.length;
    if (len <= 2) return len;
    int index = 2;
    for (int i = 2; i < len; ++i) {
      if (nums[i] != nums[index-2]) {
        nums[index++] = nums[i];
      }
    }
    return index;
  }
}
