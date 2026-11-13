class Solution {
    public String minWindow(String s, String t) {
        if (t.isBlank() || t.length() > s.length()) {
            return "";
        }

        // create a map of char and count
        Map<Character, Integer> countT = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        // load up the countT by for looping t
        for (char c : t.toCharArray()) {
            countT.put(c, countT.getOrDefault(c, 0) + 1);
        }
        // define variables needed for iterationand result
        int have = 0, need = countT.size();
        int[] res = {-1, -1};
        int resLen = Integer.MAX_VALUE;
        int l = 0;
        for (int r = 0; r < s.length(); r++) {
            // read the chars in s and load up window map with their count
            char ch = s.charAt(r);
            window.merge(ch, 1, Integer::sum);
            // window.put(ch, window.getOrDefault(ch + 1));

            // what are the have and need values ?\
            if (countT.containsKey(ch) && countT.get(ch).equals(window.get(ch))) {
                have++;
            }

            // if haves == needs; calculate the reslength and res values
            while (have == need) {
                // if woindow length is lesser than resLan ie maxInt
                if ((r - l + 1) < resLen) {
                    resLen = (r - l + 1);
                    res[0] = l;
                    res[1] = r;
                }

                // once haves == needs, reduce window start to move left pointer
                //read left char and remove the count for it from map!
                char chL = s.charAt(l);
                window.put(chL, window.get(chL) - 1);
                // now its time to update have - basically reduce
                if (countT.containsKey(chL) && window.get(chL) < countT.get(chL)) {
                    have--;
                }
                // movethe left pointer inward;
                l++;
            }
        }

            return resLen == Integer.MAX_VALUE ? "" : s.substring(res[0], res[1] + 1);
        }
    }
