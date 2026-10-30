class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> count = new HashMap<>();

        for(int i = 0 ; i<nums.length; i++){
            int n = nums[i];
            int comp = target - n; 
            if(count.containsKey(comp)){
                return new int[]{ count.get(comp),i};
            }
            count.put(n, i);
        }
        return new int[]{};
    }
}
