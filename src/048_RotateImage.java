// You are given an n x n 2D matrix representing an image.

// Rotate the image by 90 degrees (clockwise).
// Note:
// You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.

// Example 1:

// Given input matrix = 
// [
//   [1,2,3],
//   [4,5,6],
//   [7,8,9]
// ],

// rotate the input matrix in-place such that it becomes:
// [
//   [7,4,1],
//   [8,5,2],
//   [9,6,3]
// ]


class Solution {
	public void rotate(int[][] matrix) {
		int start = 0; end = matrix.length - 1;
		// layer by layer
		while (start < end) {
			// for each layer, swap elements one by one
			for (int i = start; i < end; i++) {
				int offset = i - start;
				int temp = matrix[start][i];
				matrix[start][i] = matrix[end-offset][start];
				matrix[end-offset][start] = matrix[end][end-offset];
				matrix[end][end-offset] = matrix[i][end];
				matrix[i][end] = temp;
			}
			start++;
			end--;
		}
	}
}