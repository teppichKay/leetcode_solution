// Time : O(n!) Space : O(n)
class Solution {
  public List<List<Integer>> getFactors(int n) {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    // factors: 2, 3, 5
    helper(res, list, n, 2);
    return res;
  }
  
  private void helper(List<List<Integer>> res, List<Integer> list, int n, int start) {
    // condition to stop
    if (n == 1) {
      res.add(new ArrayList<>(list));
      return;
    }
    for (int i = start; i <= n; i++) {
      if(n % i == 0) {
        list.add(i);
        helper(res, list, n / i, i);
        list.remove(list.size()-1);
      }
    }
  }
}