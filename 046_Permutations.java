// Time complexity: O(n!*n) Space complexity: O(n)

class Solution {
  public List<List<Integer>> permute(int[] nums) {
    if (nums == null || nums.length == 0) return null;
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    helper(res, list, nums);
    return res;
  }
  
  private void helper(List<List<Integer>> res, List<Integer> list, int[] nums) {
    if (list.size() == nums.length) {
      res.add(new ArrayList<>(list));
      return;
    }
    for (int i = 0; i < nums.length; i++) {
      // O(n)
      if (list.contains(nums[i])) continue;
      list.add(nums[i]);
      helper(res, list, nums);
      list.remove(list.size()-1);
    }
  }
}