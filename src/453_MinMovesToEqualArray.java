// Discussion: https://leetcode.com/problems/minimum-moves-to-equal-array-elements/discuss/93817/It-is-a-math-question
// Define sum as the sum of all the numbers, before any moves; minNum as the min number int the list; n is the length of the list;
//
// say m moves, we get all the numbers as x , and we will get the following equation
// sum + m * (n - 1) = x * n
//
// x = minNum + m
// we will get,
// sum - minNum * n = m

// Time complexity: O(n) Space: O(1)
class Solution {
    public int minMoves(int[] nums) {
        int sum = 0;
        int minNum = Integer.MAX_VALUE;
        for (int i : nums) {
            sum += i;
            minNum = Math.min(minNum, i);
        }
        return sum - minNum * nums.length;
    }
}
