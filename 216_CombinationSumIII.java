// Input: k = 3, n = 9
//
// Output:
//
// [[1,2,6], [1,3,5], [2,3,4]]
// not sure: Time complexity: O(C(9, k)) Space: O(k)

class Solution {
  public List<List<Integer>> combinationSum3(int k, int n) {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    helper(res, list, k, n, 1);
    return res;
  }

  private void helper(List<List<Integer>> res, List<Integer> list, int k, int n,
  int start) {
    if (k == 0 && n == 0) {
      res.add(new ArrayList<>(list));
      return;
    }

    for (int i = start; i <= 9 ;i++ ) {
      list.add(i);
      helper(res, list, k-1, n-i, i+1);
      list.remove(list.size()-1);
    }
  }
}
