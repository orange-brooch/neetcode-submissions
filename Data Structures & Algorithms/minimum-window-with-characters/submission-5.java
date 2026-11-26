class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length())
            return "";

        Map<Character, Integer> cT = new HashMap<>();
        Map<Character, Integer> win = new HashMap<>();



        for (char ch : t.toCharArray()) {
            cT.merge(ch, 1, Integer::sum); // x-1;y-1;z-1
        }
        int have = 0, need = cT.size(), reslen = Integer.MAX_VALUE;
        int[] res = {-1, -1};
        int l = 0;
        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            win.put(c, win.getOrDefault(c, 0) + 1);

            if (cT.containsKey(c) && win.get(c).equals(cT.get(c)))
                have++;

            while (have == need) {
                // res ?
                if (r - l + 1 < reslen) {
                    reslen = r - l + 1;
                    res[0] = l;
                    res[1] = r;
                }
                char cl = s.charAt(l);
                win.merge(cl, -1, Integer::sum);
                if (cT.containsKey(cl) && win.get(cl) < cT.get(cl)) {
                    have--;
                }
                l++;
            }
        }

        return reslen == Integer.MAX_VALUE ? "" : s.substring(res[0], res[1] + 1);
    }
}
