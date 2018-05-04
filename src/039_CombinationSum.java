// candidate set [2, 3, 6, 7] target: 7
// [
//   [7],
//   [2, 2, 3]
// ]

class Solution {
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
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
      list.add(candidates[i]);
      helper(res, list, candidates, target - candidates[i], i);
      // if target eventually doesn't equal to 0, pop this number
      list.remove(list.size() - 1);
    }
  }
}
