class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashSet<Integer> set = new HashSet<>();

        int[] result = new int[2];

        for (int i = 0 ; i < nums.length ; i++) {
            if (set.contains(target - nums[i])) {
                result[1] = i;
                break;
            }
            set.add(nums[i]);
        }

        for (int i = 0 ; i < nums.length ; i++) {
            if (nums[i] == target - nums[result[1]]) {
                result[0] = i;
                break;
            }
        }
        return result;
    }
}