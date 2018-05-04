// Given an array and a value, remove all instances of that value in-place and return the new length.
//
// Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
//
// Given nums = [3,2,2,3], val = 3,
//
// Your function should return length = 2, with the first two elements of nums being 2.

// Time complexity: O(n) Space: O(1)

// Solution: two-pointer
class Solution {
    public int removeElement(int[] nums, int val) {
        if (nums.length == 0 || nums == null) return 0;
        int j = nums.length - 1;
        int i = 0;
        while (i <= j) {
             if (nums[i] == val) {
                nums[i] = nums[j];
                j--;
            } else {
                 i++;
             }
        }
        return ++j;
    }
}
