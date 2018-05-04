// Given nums = [2, 7, 11, 15], target = 9,
//
// Because nums[0] + nums[1] = 2 + 7 = 9,
// return [0, 1].

// Time complexity: O(n)  Space: O(n)

class Solution {
  public int[] twoSum(int[] nums, int target) {
    if (nums == null || nums.length < 2) return new int[]{-1,-1};
    int[] res = new int[]{-1,-1};
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      if (map.containsKey(target - nums[i])) {
        res[0] = map.get(target - nums[i]);
        res[1] = i;
        break;
      }
      map.put(nums[i], i);
    }
    return res;
  }
}
