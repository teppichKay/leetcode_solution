// On a staircase, the i-th step has some non-negative cost cost[i] assigned (0 indexed).

// Once you pay the cost, you can either climb one or two steps. You need to find minimum cost to reach the top of the floor, and you can either start from the step with index 0, or the step with index 1.

// Example:
// Input: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
// Output: 6
// Explanation: Cheapest is start on cost[0], and only step on 1s, skipping cost[3].
// Note:
// cost will have a length in the range [2, 1000].
// Every cost[i] will be an integer in the range [0, 999].

// Dynamic Programming.
// Time complexity: O(n)	Space complexity: O(1)

class Solution {
	public int minCostClimbingStairs(int[] cost) {
		int[] dp = new int[cost.length+1];
		dp[0] = cost[0];
		dp[1] = cost[1];
		for (int i = 2; i < cost.length; i++) {
			dp[i] = Math.min(dp[i-1], dp[i-2]) + cost[i];
		}
		dp[cost.length] = Math.min(dp[cost.length-1], dp[cost.length-2]);
		return dp[cost.length];
	}
}