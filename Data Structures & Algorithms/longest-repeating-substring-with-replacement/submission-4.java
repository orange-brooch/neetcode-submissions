class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int maxfreq = 0, maxlen = 0;
        int l = 0;
        for (int r = 0; r < s.length(); r++) {
            char ch = s.charAt(r);
            map.merge(ch, 1, Integer::sum);
            maxfreq = Math.max(maxfreq, map.get(ch));
            while ((r - l + 1 - maxfreq) > k) {
                map.computeIfPresent(s.charAt(l), (ky, v) -> v - 1);
                l++;
            }
            maxlen = Math.max(r - l + 1, maxlen);
        }
        return maxlen;
    }
}
