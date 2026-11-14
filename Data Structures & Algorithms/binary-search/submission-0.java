class Solution {
    public int search(int[] nums, int target) {
        // sorted -> binary search
        int l = 0, r = nums.length - 1;
        //[-1,0,2,4,6,8] l =0 r = 5
        while (l <= r) { // t
            int mid = l + (r - l) / 2; // mid = 2; 3+2/2 = 4
            if (target == nums[mid]) {
                return mid;
            }
            else if (target > nums[mid]) { // 4 > 2 T 4 > 6 F
                l = mid+1; // l = 3
            }
            else if (target < nums[mid]) { // 4 < 6 T
                r = mid -1; // r =
            }
        }
        return -1;
    }
}
