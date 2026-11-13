class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        Set<Character> seen = new HashSet<>();
        int maxLen = 0;
        int l = 0;
        for (int r = 0; r < s.length(); r++) {
            // if no prev element found, its the beginning element
            while (seen.contains(s.charAt(r))) {
                seen.remove(s.charAt(l));
                l++;
            }
            seen.add(s.charAt(r));
            int len = r - l + 1;
            maxLen = Math.max(maxLen, len);
        }

        return maxLen;
    }
}
