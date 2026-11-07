class Solution {
    public int longestConsecutive(int[] nums) {
        // set - load up ; so no duplicates /ignores dont count more
        //  next if set !contains element -1 -> len=1(mark beginning); continueslen++ till set
        //  contains num-1; maxlen -maintain and return;
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }

        int maxLen = 0;
        for (int n : set) {
            if (!set.contains(n - 1)) {
                int length = 1; //mark beginning of sequence
                while (set.contains(n + length)) { //goes in inc of 1
                    length++;
                }
                maxLen = Math.max(maxLen, length);
            }
        }

        return maxLen;
    }
}
