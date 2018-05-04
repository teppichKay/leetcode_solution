//Write a program to find the n-th ugly number.

class Solution {
  public int nthUglyNumber(int n) {
    int[] res = new int[n];
        res[0] = 1;
        int id_2 = 0, id_3 = 0, id_5 = 0;
        for (int i = 1; i < n; i++) {
            res[i] = Math.min(res[id_2]*2, Math.min(res[id_3]*3, res[id_5]*5));
            
            // use three parallel if clauses to remove dups.
            if (res[i] == res[id_2]*2) id_2++;
            if (res[i] == res[id_3]*3) id_3++;
            if (res[i] == res[id_5]*5) id_5++;
        }
        return res[n-1];
  }
}
