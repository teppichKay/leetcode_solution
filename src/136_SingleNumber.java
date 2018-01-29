//linear runtime, without extra space -> bit manipulation
// XOR operation
// Time complexity: O(n)  space: O(1)
class Solution {
  public int singleNumber(int[] nums) {
    int res = 0;
    for (int i = 0; i < nums.length; i++) {
      res ^= nums[i];
    }
  }
}