class Solution {
    public int removeDuplicates(int[] nums) {
        int left = 0, currCnt = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[left] == nums[i] && currCnt == 0) {
                currCnt++; left++;
                nums[left] = nums[i];
            } else if (nums[left] != nums[i]) {
                currCnt = 0; left++;
                nums[left] = nums[i];
            }
        }

        return left+1;
    }
}