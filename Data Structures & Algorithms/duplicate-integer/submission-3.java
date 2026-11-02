class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        if(null == nums){
            return true;
        }
        for(int n : nums){
            if(set.contains(n)){
                return true;
            }else{
                set.add(n);
            }
        }
        return false;
    }
}