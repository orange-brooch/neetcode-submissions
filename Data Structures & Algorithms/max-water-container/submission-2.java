class Solution {
    public int maxArea(int[] heights) {
        int maxArea = 0;
        int len = heights.length;
        if (len == 0) {
            return 0;
        }
        int l = 0, r = len - 1;
        while (l < r) {
            int h = Math.min(heights[l], heights[r]);
            int w = r - l;
            int area = h * w;

            maxArea = Math.max(maxArea, area);

            if (heights[l] >= heights[r]) {
                r--;
            } else {
                l++;
            }
        }
        return maxArea;
    }
}
