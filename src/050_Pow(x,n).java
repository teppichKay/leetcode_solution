// This solution will not have stackoverflow error
// Time : O(logn)  Space: O(1)

class Solution {
  public double myPow(double x, int n) {
    if (n < 0) return 1.0 / power(x, -n);
    else return power(x,n);
  }
  
  public double power(double x, int n) {
    if (n==0) return 1;
    double res = power(x, n / 2);
    if ( n % 2 == 0) return res * res;
    else return res * res * x;
  }
}