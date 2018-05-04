// For example,
// Given n = 3,
//
// You should return the following matrix:
// [
//  [ 1, 2, 3 ],
//  [ 8, 9, 4 ],
//  [ 7, 6, 5 ]
// ]
// Time: O(n^2)  Space: O(n^2)

class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int rowStart = 0, rowEnd = n - 1;
        int colStart = 0, colEnd = n - 1;
        int count = 1;
        while (rowStart <= rowEnd && colStart <= colEnd) {
            for (int i = colStart; i <= colEnd; i++) {
                matrix[rowStart][i] = count++;
            }
            rowStart++;
            for (int i = rowStart; i <= rowEnd; i++) {
                matrix[i][colEnd] = count++;
            }
            colEnd--;
            for (int i = colEnd; i>= colStart; i--) {
                matrix[rowEnd][i] = count++;
            }
            rowEnd--;
            for (int i = rowEnd; i>= rowStart; i--) {
                matrix[i][colStart] = count++;
            }
            colStart++;
        }
        return matrix;
    }
}
