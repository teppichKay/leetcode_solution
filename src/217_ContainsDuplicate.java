// Time complexity: O(nlogn)  Space: O(1)
// if we use HashSet, time complexity will be O(n), space: O(n)

class Solution {
  public boolean containsDuplicate(int[] nums) {
    Arrays.sort(nums);
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] == nums[i-1]) return true;
    }
    return false;
  }
}
