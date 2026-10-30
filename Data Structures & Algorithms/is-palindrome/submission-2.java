class Solution {
    public boolean isPalindrome(String s) {
        int n = s.length();
        int lt = 0;
        int rt = n - 1;
        if (s.isEmpty()) {
            return false;
        }
        while (lt < rt) {
            if (!Character.isLetterOrDigit(s.charAt(lt))) {
                lt++;
            }
            else if (!Character.isLetterOrDigit(s.charAt(rt))) {
                rt--;
            }
            else if (Character.toLowerCase(s.charAt(lt)) != Character.toLowerCase(s.charAt(rt))){
                return false;
            } else {
                lt++;
                rt--;
            }
        }
        return true;
    }
}
