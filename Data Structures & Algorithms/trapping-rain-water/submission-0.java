class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int l = 0, r = n - 1;
        int lmax = height[l], rmax = height[r];
        int count = 0;

        while (l < r) {
            if(lmax <= rmax){
                l++;
                lmax = Math.max(lmax, height[l]);
                count = count + lmax - height[l];
            } else{
                r--;
                rmax = Math.max(rmax, height[r]);
                count+= rmax - height[r];
            }
            
        }

        return count;
    }
}
