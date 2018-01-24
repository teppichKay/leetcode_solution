// For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8,
// A solution set is:
// [
//   [1, 7],
//   [1, 2, 5],
//   [2, 6],
//   [1, 1, 6]
// ]
// Time complexity: O(2^n) Space: O(n)

class Solution {
  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    // first: sort the array
    Arrays.sort(candidates);
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    helper(res, list, candidates, target, 0);
    return res;
  }

  private void helper(List<List<Integer>> res, List<Integer> list, int[] candidates,
  int target, int id) {
    if (target < 0) return;
    if (target == 0) {
      res.add(new ArrayList<>(list));
      return;
    }

    for (int i = id; i < candidates.length; i++) {
      // remove dups
      if (i > id && candidates[i] == candidates[i-1]) continue;
      list.add(candidates[i]);
      helper(res, list, candidates, target - candidates[i], i + 1);
      list.remove(list.size() - 1);
    }
  }
}
