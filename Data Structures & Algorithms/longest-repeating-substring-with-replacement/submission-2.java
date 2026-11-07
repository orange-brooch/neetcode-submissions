class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int l = 0, maxlen = 0, maxCount = 0;

        for (int r = 0; r < s.length(); r++) {
            map.merge(s.charAt(r), 1, Integer::sum);
            maxCount = Math.max(maxCount, map.get(s.charAt(r)));
            while ((r - l + 1) - maxCount > k) {
                map.computeIfPresent(s.charAt(l), (ky, v) -> v - 1);
                l++;
            }
            maxlen = Math.max(maxlen, (r - l + 1));
        }
        return maxlen;
    }
}
