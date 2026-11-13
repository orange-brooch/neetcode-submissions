class Solution {
    public boolean checkInclusion(String s1, String s2) {
        // frequence array
        // a0 b1 c2 d3 e4 f5 g6 h7 i8 j9 k10 l11 m12 n13 o14 p15 q16 r17 s18 t29 u20 v21 w22 x23 y24
        // z25

        if(s1.length() > s2.length()){
            return false;
        }

        int[] s1count = new int[26];
        int[] s2count = new int[26];
        // iterate through s1 elements
        for (int i = 0; i < s1.length(); i++) {
            int indexl = s1.charAt(i) - 'a'; // since all lower case
            s1count[indexl]++;
            int indexr = s2.charAt(i) - 'a';
            s2count[indexr]++;
        }
        // iterate bounded 26 times to find matches so far
        int matches = 0;
        for (int i = 0; i < 26; i++) {
            if (s1count[i] == s2count[i]) {
                matches++;
            }
        }
        int l = 0;
        // iterate through s2 elements
        // move right pointer with for loop
        for (int r = s1.length(); r < s2.length(); r++) {
            // if freq array matched - its true match
            if (matches == 26)
                return true;

            int index = s2.charAt(r) - 'a';
            s2count[index]++;

            if (s1count[index] == s2count[index]) {
                matches++;
            } else if (s1count[index] + 1 == s2count[index]) {
                matches--;
            }

            index = s2.charAt(l) - 'a';
            s2count[index]--;
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
