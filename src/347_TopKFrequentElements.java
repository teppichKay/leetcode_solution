// Given a non-empty array of integers, return the k most frequent elements.
//
// For example,
// Given [1,1,1,2,2,3] and k = 2, return [1,2].
//
// hashmap + priorityqueue
// Time complexity: O(klogn) Space complexity: O(n)

class Solution {
  public List<Integer> topKFrequent(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<>();

    List<Integer> res = new ArrayList<>();
    for (int i : nums) {
      if (map.get(i) == null) map.put(i, 1);
      else {
        map.put(i, map.get(i) + 1);
      }
      // map.put(i, map.getOrDefault(i, 0) + 1);
    }
    // write a comparator for hashmap stuff
    PriorityQueue<Map.Entry<Integer, Integer>> maxHeap =
      new PriorityQueue<>((a, b) -> (b.getValue() - a.getValue()));
    for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
      maxHeap.add(entry);
    }
    while (res.size() < k) {
      res.add(maxHeap.poll().getKey());
    }
    return res;
  }
}
