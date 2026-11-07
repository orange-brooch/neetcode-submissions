class Solution {
    public int maxArea(int[] heights) {
        int maxarea = 0;
        int l = 0, r = heights.length - 1;

        while (l < r) {
            int area = (r - l ) * Math.min(heights[l], heights[r]);
            if (heights[l] <= heights[r]) {
                l++;
            } else if (heights[l] > heights[r]) {
                r--;
            }
            maxarea = Math.max(maxarea, area);
        }
        return maxarea;
    }
}
