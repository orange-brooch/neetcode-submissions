class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] s1c = new int[26];
        int[] s2c = new int[26];
        if (s2.length() < s1.length()) {
            return false;
        }

        for (int i = 0; i < s1.length(); i++) {
            s1c[s1.charAt(i) - 'a']++;
            s2c[s2.charAt(i) - 'a']++;
        }
        int matches = 0;
        for (int i = 0; i < 26; i++) {
            if (s1c[i] == s2c[i])
                matches++;
        }
        int l = 0;
        for (int r = s1.length(); r < s2.length(); r++) { // aabee
            if (matches == 26) // F
                return true;

            int idx = s2.charAt(r) - 'a'; // a
            s2c[idx]++;
            if (s1c[idx] == s2c[idx]) // F
                matches++;
            else if (s1c[idx] + 1 == s2c[idx]) // 2a == s2?F
                matches--;

            idx = s2.charAt(l) - 'a'; // l
            s2c[idx]--; // rm l
            if (s1c[idx] == s2c[idx]) // F
                matches++;
            else if (s1c[idx] - 1 == s2c[idx])
                matches--;
            l++; // l=1
        }
        return matches == 26;
    }
}
