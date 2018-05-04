class Solution {
  public List<List<Integer>> subsetsWithDup(int[] nums) {
    if (nums.length == 0 || nums == null) return null;
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    Arrays.sort(nums);
    helper(res, list, nums, 0);
    return res;
  }

  private void helper(List<List<Integer>> res, List<Integer> list, int[] nums, int start) {
    res.add(new ArrayList<>(list));
    for (int i = start; i < nums.length; i++ ) {
      if (i != start && nums[i] == nums[i-1]) continue;
      list.add(nums[i]);
      helper(res, list, nums, i+1);
      list.remove(list.size()-1);
    }
  }
}
