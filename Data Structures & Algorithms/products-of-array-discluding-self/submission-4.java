class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        // prefix calc
        res[0] = 1;
        for (int i = 1; i < n; i++) { // 1,2,8,46
            res[i] = res[i - 1] * nums[i - 1];
        }

        // postfix cal - right to left
        int postfix = 1; // nums [1,2,4,6]
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= postfix;
            postfix *= nums[i];
        }
        return res;
    }
}
