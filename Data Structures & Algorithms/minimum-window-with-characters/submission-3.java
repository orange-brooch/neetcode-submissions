class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> cT = new HashMap<>();
        Map<Character, Integer> win = new HashMap<>();
        for (char c : t.toCharArray()) {
            cT.put(c, cT.getOrDefault(c, 0) + 1);
        }
        int have = 0, need = cT.size(), reslen = Integer.MAX_VALUE, l = 0;
        int[] res = {-1, -1};

        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            win.merge(c, 1, Integer::sum);

            if (cT.containsKey(c) && win.get(c).equals(cT.get(c)))
                have++;

            while (have == need) {
                if ((r - l + 1) < reslen) {
                    reslen = r - l + 1;
                    res[0] = l;
                    res[1] = r;
                }

                char left = s.charAt(l);
                win.merge(left, -1, Integer::sum);

                if(cT.containsKey(left) && win.get(left) < cT.get(left))
                have--;

                l++;
            }
        }
        return reslen == Integer.MAX_VALUE ? "" : s.substring(res[0], res[1]+1);
    }
}
