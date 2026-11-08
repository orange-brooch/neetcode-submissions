class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.isBlank() || s2.isBlank() || s1.length() > s2.length()) {
            return false;
        }
        // frequency chars -  26 letter
        int[] s1count = new int[26];
        int[] s2count = new int[26];

        int m = s1.length();
        // iterate through s1
        for (int i = 0; i < m; i++) {
            s1count[s1.charAt(i) - 'a']++;
            s2count[s2.charAt(i) - 'a']++;
        }
        // check for matches o(26)
        int matches = 0;
        for (int i = 0; i < 26; i++) {
            if (s1count[i] == s2count[i])
                matches++;
        }

        int l = 0;
        // iterate through remaining of s2
        for (int r = m; r < s2.length(); r++) {
            // matches check ?
            if (matches == 26) {
                return true;
            }
            int index = s2.charAt(r) - 'a';
            s2count[index]++;
            if (s1count[index] == s2count[index]) {
                matches++;
            } else if (s1count[index] + 1 == s2count[index]) {
                matches--;
            }
            // for every char at l index we rremove
            index = s2.charAt(l) - 'a';
            s2count[index]--; //reduce the count as we move the left pointer of the window
            if (s1count[index] == s2count[index]) {
                matches++;
            } else if (s1count[index] - 1 == s2count[index]) {
                matches--;
            }
            l++;
        }

        return matches == 26;
    }
}
