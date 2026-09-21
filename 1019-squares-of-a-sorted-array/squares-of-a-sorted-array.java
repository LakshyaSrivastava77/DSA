class Solution {
    public int[] sortedSquares(int[] nums) {
        // for (int i = 0; i < nums.length; i++) {
        //     nums[i] *= nums[i];
        // }

        int[] result = new int[nums.length];
        int left = 0, right = nums.length-1, idx = nums.length-1;

        while (left <= right) {
            if((nums[left] * nums[left]) > (nums[right] * nums[right])) result[idx--] = nums[left] * nums[left++];
            else result[idx--] = nums[right] * nums[right--];
        }

        return result;
    }
}