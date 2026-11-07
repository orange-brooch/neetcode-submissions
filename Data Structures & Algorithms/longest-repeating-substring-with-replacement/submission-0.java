class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0, maxFreq = 0;
        Map<Character, Integer> map = new HashMap<>();
        int longLength = 0;
        for (int r = 0; r < s.length(); r++) {
            map.merge(s.charAt(r), 1, Integer::sum);
            maxFreq = Math.max(maxFreq, map.get(s.charAt(r)));
            while ((r - l + 1) - maxFreq > k) {
                // reduce window, inc l and reduce count
                map.computeIfPresent(s.charAt(l), (ky, v) -> v - 1);
                l++;
            }
            longLength = Math.max(longLength, (r-l+1));
        }
        return longLength;
    }
}
