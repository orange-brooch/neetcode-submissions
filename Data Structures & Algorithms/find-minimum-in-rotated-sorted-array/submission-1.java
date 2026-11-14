class Solution {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            int mid = nums[m];
            if (mid < nums[r]) { //mid is least and right half is sorted
                r = m;
            } else { //means mid > r - rotated to right, so min value in right; move  left  pointer here.
                l = m + 1;
            }
        }
        return nums[l];
    }
}
