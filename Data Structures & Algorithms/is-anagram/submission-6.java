class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int n = s.length();
        int[] countS = new int[26];
        int[] countT = new int[26];
        for (int i = 0; i < n; i++) {
            countS[s.charAt(i) - 'a']++;
            countT[t.charAt(i) - 'a']++;
        }
        return Arrays.equals(countS, countT);
    }
}
