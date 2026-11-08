class Solution {
    public boolean checkInclusion(String s1, String s2) {
        boolean result = false;
        int m = s1.length();
        if (s1.isBlank() || s2.isBlank() || s1.length() > s2.length()) {
            return result;
        }
        char[] charS1 = s1.toCharArray();
        Arrays.sort(charS1);

        int l = 0;
        for (int r = 0; r < s2.length(); r++) {
            char targetChar = s2.charAt(r);
            if (new String(charS1).chars().anyMatch(ch -> ch == targetChar)) {
                l = r;
                if (l + s1.length() <= s2.length()) {
                    String subarray = s2.substring(r, l + s1.length());
                    char[] ssChararray = subarray.toCharArray();
                    Arrays.sort(ssChararray);
                    result = Arrays.equals(ssChararray, charS1);
                } 

                if (result == true) {
                    break;
                }
            }
        }

        return result;
    }
}
