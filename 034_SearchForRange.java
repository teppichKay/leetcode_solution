// Time complexity: O(logn) Space complexity: O(1)
class Solution {
  public int[] searchRange(int[] nums, int target) {
    if (nums == null || nums.length == 0) return new int[]{-1,-1};
    int first = findFirst(nums, target);
    if (first == -1) return new int[]{-1,-1};

    int last = findLast(nums, target);
    return new int[]{first, last};
  }

  private int findFirst(int[] nums, int target) {
    int low = 0;
    int high = nums.length - 1;
    while (low + 1 < high) {
      int mid = (high - low) / 2 + low;
      if (nums[mid] < target) {
        low = mid;
      } else {
        high = mid;
      }
    }
    if (nums[low] == target) return low;
    else if (nums[high] == target) return high;
    return -1;
  }

  private int findLast(int[] nums, int target) {
    int low = 0;
    int high = nums.length - 1;
    while (low + 1 < high) {
      int mid = (high - low) / 2 + low;
      if (nums[mid] > target) {
        high = mid;
      } else {
        low = mid;
      }
    }
    if (nums[high] == target) return high;
    else if (nums[low] == target) return low;
    return -1;
  }
}
