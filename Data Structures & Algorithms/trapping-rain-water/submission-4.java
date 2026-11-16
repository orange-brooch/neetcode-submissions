class Solution {
    public int trap(int[] height) {
        if (height == null) {
            return 0;
        }

        int l = 0, r = height.length - 1;
        int lmax = height[l], rmax = height[r];
        int count = 0;

        while (l < r) {
            if (lmax <= rmax) {
                l++;
                lmax = Math.max(lmax, height[l]);
                count += lmax - height[l];

            } else {
                r--;
                rmax = Math.max(rmax, height[r]);
                count += rmax - height[r];
            }
        }
        return count;
    }
}
