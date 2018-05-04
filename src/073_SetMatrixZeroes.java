// Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.


// Space complexity has to be O(1).
// so we should use marks on the first row and first column to handle elements that should be set to 0.

class Solution {
	public void setZeroes(int[][] matrix) {
		// first mark on the first row and col.
		boolean zeroAtFirstRow = false;
		boolean zeroAtFirstCol = false;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					matrix[0][j] = 0;
					matrix[i][0] = 0;
					if (i == 0) zeroAtFirstRow = true;
					if (j == 0) zeroAtFirstCol = true;
				}
			}
		}
		// update elements inside 
		for (int i = 1; i < matrix.length; i++) {
			for (int j = 1; j < matrix[0].length; j++) {
				if (matrix[0][j] == 0 || matrix[i][0] == 0) {
					matrix[i][j] = 0;
				}
			}
		}

		// check if the first row and col should be updated
		if (zeroAtFirstRow) {
			for (int j = 0; j < matrix[0].length; j++) {
				matrix[0][j] = 0;
			}
		}

		if (zeroAtFirstCol) {
			for (int i = 0; i < matrix.length; i++) {
				matrix[i][0] = 0;
			}
		}
	}
}
