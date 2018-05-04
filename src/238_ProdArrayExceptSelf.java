// Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

// Solve it without division and in O(n).

// For example, given [1,2,3,4], return [24,12,8,6].

// Solution 1: loop from left to right, then right to left.

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] left = new int[len];
        int[] right = new int[len];
        int[] res = new int[len];
        left[0] = 1; 
        right[len-1] = 1;
        for (int i = 1; i < len; i++) {
            left[i] = left[i-1] * nums[i-1];
        }

        for (int i = len-2; i >= 0; i--) {
            right[i] = right[i+1] * nums[i+1];
        }

        for (int i = 0; i < len; i++) {
            res[i] = left[i] * right[i];
        }
        return res;
    }
}



// Solution 2: use only one array.
// https://leetcode.com/problems/product-of-array-except-self/discuss/65622/simple-java-solution-in-on-without-extra-space

public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= right;
            right *= nums[i];
        }
        return res;
    }
}