class Solution {
    public int[] twoSum(int[] nums, int target) {
        // sorted nums  asc - with duplicates
        int[] res = new int[1];
        int l = 0, r = nums.length - 1;
        while (l<r) {
            int sum = nums[l] + nums[r];
            if (sum == target) {
                return new int[] {l + 1, r + 1};
            }
            if (sum < target) {
                l++;
            } else {
                r--;
            }
        }
        return res;
    }
}
