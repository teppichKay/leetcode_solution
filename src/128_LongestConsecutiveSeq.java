// Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
//
// For example,
// Given [100, 4, 200, 1, 3, 2],
// The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
//
// Your algorithm should run in O(n) complexity.
//
// Arrays.sort() uses O(nlogn) time complexity, which cannot be chosen.
//
// Solution: HashSet, lookup method only takes O(1) complexity.
// Total time complexity: O(n)  Space: O(n)

class Solution {
  public int longestConsecutive(int[] nums) {
    if (nums.length == 0 || nums == null) return 0;
    HashSet<Integer> set = new HashSet<>();
    for (int num: nums) {
      set.add(num);
    }

    int longest = 0;
    for (int num: nums) {
      // for each num in the array, lookup its higher and lower bounds, remove nums
      // from the set and store the longest length
      int high = num;
      int len = 0;
      while (set.contains(high)) {
        len++;
        set.remove(high);
        high++;
      }

      int low = num - 1;
      while (set.contains(low)) {
        len++;
        set.remove(low);
        low--;
      }
      longest = Math.max(longest, len);
    }
    return longest;
  }
}
