class Solution {
    public int maximumCount(int[] nums) {
        int neg = 0, pos = 0;
        int left = 0, right = nums.length-1;

        while (left <= right) {
            int mid = left + (right - left)/2;
            if (nums[mid] > 0 && (mid == 0 || nums[mid-1] <= 0)) {
                pos = nums.length - mid;
                break;
            }

            if (nums[mid] > 0) right = mid-1;
            else left = mid+1;
        }

        left = 0; right = nums.length-1;
        while (left <= right) {
            int mid = left + (right - left)/2;
            if (nums[mid]  < 0 && (mid == nums.length-1 || nums[mid+1] >= 0)) {
                neg = mid + 1;
                break;
            }

            if (nums[mid] >= 0) right = mid-1;
            else left = mid+1;
        }

        return Math.max(pos , neg);
    }
}