class Solution {
    public boolean isPalindrome(String s) {
        // 2 pointer start and end of string - ignore space/spl chars. neutralize case; if != return
        // false else true;
        int start = 0, end = s.length() - 1;
        while (start < end) {
            // while not a alpha num ++ or --
            while (start < end && !alphaNum(s.charAt(start))) {
                start++;
            }
            while (start < end && !alphaNum(s.charAt(end))) {
                end--;
            }
            char charl = Character.toLowerCase(s.charAt(start));
            char charr = Character.toLowerCase(s.charAt(end));
            // isDigitOrAlpha? //how to check for space
            if (charl != charr) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public boolean alphaNum(char c) {
        return 
        (
            c >= 'A' && c <= 'Z' ||
            c >= 'a' && c <= 'z' ||
            c >= '0' && c <= '9'
            );
    }
}
