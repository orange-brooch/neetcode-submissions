class Solution {
    public int[] productExceptSelf(int[] num) {
        //prefix and postfix 
        int n = num.length;
        int[] res = new int[n];
        
        res[0] = 1;
        for(int i = 1; i<n; i++){
            res[i] = res[i-1] * num[i-1];
        }
        
        int postfix = 1;
        for(int i = n-1; i>=0; i--){
            res[i] *= postfix;
            postfix *= num[i];
        }
        return res;
    }
}  
