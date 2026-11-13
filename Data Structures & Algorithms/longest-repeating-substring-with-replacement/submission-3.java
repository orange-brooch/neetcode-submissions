class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> count = new HashMap<>();
        int maxlen = 0, maxF = 0;
        int l = 0;
        // slow and fast pointer
        for (int r = 0; r < s.length(); r++) { // AAABABB
            char ch = s.charAt(r);
            count.merge(ch, 1, Integer::sum);
            //max count since count just updated or prev max ?
            maxF = Math.max(maxF, count.get(ch));
            // condition that failes length beyond substition k value
            while (((r - l + 1) - maxF) > k) {
                count.computeIfPresent(s.charAt(l), (ky, v) -> v - 1);
                l++;
            }

            maxlen = Math.max(maxlen, r - l + 1);
            
        }
        return maxlen;
    }
}
