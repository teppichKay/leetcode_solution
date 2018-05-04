// Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.
//
// Note: You may not slant the container and n is at least 2.
//
// Time : O(n)  Space: O(1)
//
// Solution: two-pointer

class Solution {
  public int maxArea(int[] height) {
    int start = 0;
    int end = height.length - 1;
    int area = Integer.MIN_VALUE;
    while (start < end) {
      int cur = Math.min(height[start], height[end]);
      area = Math.max(cur, area);
      if (height[start] < height[end]) start++;
      else end--;
    }
    return area;
  }
}
