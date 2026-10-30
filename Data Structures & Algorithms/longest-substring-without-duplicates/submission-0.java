class Solution {
    public int lengthOfLongestSubstring(String s) {

        Set<Character> charSet = new HashSet<>();
        int l =0, len = 0;
// slow and fast pointers
        for(int r = 0; r<s.length(); r++){
            while(charSet.contains(s.charAt(r))){
                charSet.remove(s.charAt(l));
                l++;
            }
            charSet.add(s.charAt(r));
            len = Math.max(len, r-l+1);

        }

        return len;
    }
}
