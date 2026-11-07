class Solution {
    public String encode(List<String> strs) {
        // num(length) + sp char+ word +...
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            int len = s.length();
            char spl = '#';
            sb.append(len).append(spl).append(s);
        }
        // 5#hello5#world
        return sb.toString();
    }

    public List<String> decode(String str) {
        // i and j 2-pointer
        // 5#hello5#world
        // i=j=0
        List<String> slist = new ArrayList<>();
        char spl = '#';
        int n = str.length();
        int i = 0;
        while (i < n) {
            int j = i;
            while (str.charAt(j) != spl) {
                j++;
            }
            int len = Integer.parseInt(str.substring(i, j));
            i = j + 1;
            j = i + len;
            slist.add(str.substring(i, j));
            i = j;
        }
        return slist;
    }
}
