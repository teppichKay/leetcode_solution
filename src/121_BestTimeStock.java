// Say you have an array for which the ith element is the price of a given stock on day i.
//
// If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
//
// Example 1:
// Input: [7, 1, 5, 3, 6, 4]
// Output: 5
//
// Example 2:
// Input: [7, 6, 4, 3, 1]
// Output: 0
//
// Time complexity: O(n)  Space: O(1)
// Greedy algorithm

class Solution {
  public int maxProfit(int[] prices) {
    if (prices == null || prices.length == 0) return 0;

    int profit = 0;
    int minStock = prices[0];
    for (int i = 1; i < prices.length; i++) {
      profit = Math.max(profit, prices[i] - minStock);
      minStock = Math.min(minStock, prices[i]);
    }

    return profit;
  }
}
