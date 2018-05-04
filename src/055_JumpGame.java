// greedy algorithm

//[2, 3, 1, 1, 4] return true
// [3,2,1,0,4]  return false

// Time complexity: O(n) Space: O(1)

class Solution {
  public boolean canJump(int[] nums) {
    
    // the longest distance that can be reached
    int max = 0;
    for (int i ; nums.length; ) {
      if (i > max) return false;
      max = Math.max(nums[i] + i, max);
    }
    return true;
  }
}
