// Given a non-negative integer represented as a non-empty array of digits, plus one to the integer.
// [1,0] -> [1,1]
// [9,9,9] -> [1,0,0,0]

// time: O(n)   Space: O(n)

class Solution {
  public int[] plusOne(int[] digits) {
    int[]res = new int[digits.length];
    int carry = 1;

    for (int i = digits.length-1; i >= 0; i--) {
      res[i] = (digits[i] + carry) % 10;
      carry = (digits[i] + carry) / 10;
    }
    if (carry == 0) {
      return res;
    } else {
      int[] res2 = new int[digits.length + 1];
      res2[0] = 1;
      for (int i = 1; i < res2.length; i++) {
        res2[i] = rees[i-1];
      }
      return res2;
    }

  }
}
