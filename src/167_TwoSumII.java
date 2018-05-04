// Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
// You may assume that each input would have exactly one solution and you may not use the same element twice.
// Input: numbers={2, 7, 11, 15}, target=9
// Output: index1=1, index2=2
//
// Two pointers solution is efficient.
// Time complexity: O(n)  Space: O(1)

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int start = 0;
        int end = numbers.length - 1;
        while (start < end) {
            int sum = numbers[start] + numbers[end];
            if (sum == target) return new int[]{start+1, end+1};
            else if (sum < target) start++;
            else end--;
        }

        return new int[]{-1,-1};
    }
}
