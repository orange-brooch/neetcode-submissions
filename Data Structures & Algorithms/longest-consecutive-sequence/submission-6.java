class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        // the return value
        int maxLen = Integer.MIN_VALUE;

        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }

        // iterate through the the set
        for (int num: set) {
            // if there is no n -1 in the set; its the starting of sequence
            if (!set.contains(num - 1)) {
                int len = 1;
                while (set.contains(num + len)) {
                    len++;
                }
                 maxLen = Math.max(maxLen, len);
            }
           
        }

        return maxLen;
    }
}
