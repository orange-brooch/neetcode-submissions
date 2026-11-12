class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int res = 0;
        int l = 0;
        int r = height.length - 1;
        int lmax = height[l];
        int rmax = height[r];
        // this condition makes sure we iterate thru the array once till we meet int he middle
        while (l < r) {
            // the pointer movement is defined by the lmax and rmax values
            if (lmax <= rmax) {
                l++;
                // since l inced, we recal lamx now
                lmax = Math.max(lmax, height[l]);
                //any diff is the water
                res += lmax - height[l];
            }
//similarly if l > r > r--;
            else {
                r--;
                // since we moved r, now recaln rmax
                rmax = Math.max(rmax, height[r]);
                // diff is the water
                res += rmax - height[r];
            }
        }
        return res;
    }
}
