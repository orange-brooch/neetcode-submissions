class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;

        while (l <= r) {
            int m = l + (r - l) / 2;
            int mid = nums[m];
            int left = nums[l];
            int right = nums[r];
            if (mid == target) {
                return m;
            }
            if (left <= mid) { // left is  sorted
                if (left <= target && target < mid) {
                    // target is int he left mid
                    r = m - 1;

                } else {
                    l = m + 1;
                }
            } else { // right is sorted
                if (mid < target && target <= right) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
        }
        return -1;
    }
}
