class Solution {
    public int characterReplacement(String s, int k) {
        int[] array = new int[26];
        int maxfreq = 0, maxlen = 0;
        int l = 0;
        for (int r = 0; r < s.length(); r++) {
            int idx = s.charAt(r) - 'A';
            array[idx]++;
            maxfreq = Math.max(maxfreq, array[idx]);
            while ((r - l + 1 - maxfreq) > k) {
                array[s.charAt(l) - 'A']--;
                l++;
            }
            maxlen = Math.max(r - l + 1, maxlen);
        }
        return maxlen;
    }
}
