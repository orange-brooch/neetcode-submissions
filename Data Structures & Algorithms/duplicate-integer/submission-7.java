class Solution {
    public boolean hasDuplicate(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;

        int l = 0, r = l + 1;
        while (r < n) {
            if (nums[l] == nums[r]) {
                return true;
            }
            l++;
            r++;
        }
        return false;
    }
}