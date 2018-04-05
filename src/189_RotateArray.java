// Solution 1 : use extra space
// Time complexity: O(n) 	Space complexity: O(n)

class Solution {
    public void rotate(int[] nums, int k) {
        if (nums.length == 0 || nums == null) return; 
        int[] arr = new int[nums.length];
        k %= nums.length;
        for (int i = 0; i < nums.length; i++) {
            arr[i] = nums[(i+nums.length-k)%nums.length]; 
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = arr[i];
        }
    }
}

// Solution 2: reverse 3 times.
// Time complexity: O(n)	Space complexity: O(1)
// https://leetcode.com/problems/rotate-array/solution/
class Solution {
	public void rotate(int[] nums, int k) {
		if (nums.length == 0 || nums == null) return;
		k %= nums.length;
		reverse(nums, 0, nums.length - k - 1);
        reverse(nums, nums.length - k, nums.length - 1);
        reverse(nums, 0, nums.length - 1);
	}

	public void reverse(int[] nums, int start, int end) {
		while (start < end) {
			int temp = nums[start];
			nums[start] = nums[end];
			nums[end] = temp;
			start++;
			end--;
		}
	}
}