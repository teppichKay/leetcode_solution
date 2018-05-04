// Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.

// Time complexity: O(logN)   Space: O(1)

class Solution {
  public boolean isUgly(int num) {
    while (num >= 2) {
      if (num % 2 == 0) num /= 2;
      else if (num % 3 == 0) num /= 3;
      else if (num % 5 == 0) num /= 5;
      else return false;
    }
    return num == 1;
  }
}
