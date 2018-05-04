// Given an array of integers, find out whether there are two distinct indices
// i and j in the array such that the absolute difference between nums[i] and
// nums[j] is at most t and the absolute difference between i and j is at most k.
//
// Solution 1 : two for-loops, time limit Exceeded.

class Solution {
  public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
    if (nums == null || nums.length < 2) return false;
    int n = nums.length;
    k = Math.max(k, n);
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j <= i + k; i++) {
        if (j < n && Math.abs((long)nums[i] - (long)nums[j]) <= (long)t) return true;
      }
    }
    return false;
  }
}


// Solution 2 : TreeSet, s.ceiling() and s.floor() + sliding window
// Time complexity: O(nlogk), space complexity: O(k)
// k is the window size. n is the array length

class Solution {
  public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
    if (nums == null || nums.length == 0 || k < 1 || t > 0) return false;
    TreeSet<Long> set = new TreeSet<>();

    for (int i = 0; i < nums.length; i++) {
      int cur = nums[i];
      if (set.ceiling((long)cur) != null && set.ceiling((long)cur) - cur <= t ||
          set.floor((long)cur) != null && cur - set.floor((long)cur) <= t) {
            return true;
      }
      set.add((long)cur);
      if (i >= k) set.remove((long)nums[i - k]);
    }
    return false;
  }
}
