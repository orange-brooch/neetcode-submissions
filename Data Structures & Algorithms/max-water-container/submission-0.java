class Solution {
    public int maxArea(int[] heights) {

        //use 2 pointers to iterate through
        int n = heights.length;
        int lt = 0;
        int rt = n-1;
        int maxArea = Integer.MIN_VALUE; 

        while(lt < rt){
            //area = h * w;
            int area = Integer.MIN_VALUE; 
            int height = Math.min(heights[lt], heights[rt]);
            int width = rt - lt;
            area = height * width;

            maxArea = Math.max(maxArea, area);

            if(heights[lt] <= heights[rt]){
                lt++;

            }else{
                rt--;
            }


        }
        return maxArea;
    }
}
