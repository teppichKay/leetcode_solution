// Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
//
// For example,
// Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
// Time: O(n)  Space: O(n)
class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0) return 0;

        int[] left_peak = new int[height.length];
        int[] right_peak = new int[height.length];
        left_peak[0] = 0;
        right_peak[height.length - 1] = 0;
        // left to right
        for (int i = 1; i < height.length; i++) {
            left_peak[i] = Math.max(left_peak[i-1], height[i-1]);
        }
        // right to left
        for (int i = height.length - 2; i >= 0; i--) {
            right_peak[i] = Math.max(right_peak[i+1], height[i+1]);
        }

        // find the min(left_peak, right_peak) - height, sum them up.
        int sum = 0;
        for (int i = 0; i < height.length; i++) {
            int cur = Math.min(left_peak[i], right_peak[i]);
            if (cur > height[i]) sum += cur - height[i];
        }

        return sum;
    }
