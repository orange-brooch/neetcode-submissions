class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];

        res[0] = 1;
        //prefix product
        for(int i = 1; i < len; i++){
            res[i] = res[i-1] * nums[i-1];
        }

        int postfix = 1;
        //postfix prod from the other end
        for(int i = len-1; i>=0; i--){
            res[i] *= postfix;
            postfix *= nums[i];
        }
        return res;
    }
}  
