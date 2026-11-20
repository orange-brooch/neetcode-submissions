class Solution {
    public int removeDuplicates(int[] nums) {
        /* nums = [1,1,2,3,4]
        l = 1, r =1;
        */
        int l = 1;
        //[2,10,10,30,30,30]
        for (int r = 1; r < nums.length; r++) { // l = 10, r = 10; r = 30;
            if (nums[r] != nums[r - 1]) { // 10!=10 F; 10!=10 F;10!=30 T;
                nums[l] = nums[r]; // n[l] = n[1] = n[r] ie n[3]
                l++;
                // r moves by for loop
            }
            // r ==> 1+1; 2+1;
        }

        return l;
    }
}