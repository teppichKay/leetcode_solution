// Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.
//
// Note:
// You must not modify the array (assume the array is read only).
// You must use only constant, O(1) extra space.
// Your runtime complexity should be less than O(n2).
// There is only one duplicate number in the array, but it could be repeated more than once.
//
// Analysis:
// Arrays.sort(), HashMap etc cannot be used.
// Integer is between 1 and n, so if n = 10, if there are 6 numbers less than 5, it means
// the dup one is in the first half of the array.
//
// Binary search. Time complexity: O(nlogn), space complexity: O(1)

class Solution {
  public int findDuplicate(int[] nums) {
    int min = 0;
    int max = nums.length - 1;
    while (min <= max) {
      int mid = (max - min) / 2 + min;
      int count = 0;

      for (int i = 0; i < nums.length; i++) {
        if (nums[i] <= mid) {
          count++;
        }
      }
      if (count > mid) max = mid - 1;
      else min = mid + 1;
    }
    return min;
  }
}
