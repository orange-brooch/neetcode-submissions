class Solution {
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            //"Hello" -> 5#Hello
            int len = s.length();
            char ch = '#';
            sb.append(len).append(ch).append(s);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        // 5#Hello5#World
        List<String> liststr = new ArrayList<>();
        int l = 0, r = 0;
        while (r < str.length()) {
            while (str.charAt(l) != '#') {
                l++;
            }
            int len = Integer.parseInt(str.substring(r, l));
            r = l;
            liststr.add(str.substring(l + 1, l + 1 + len));
            l = l + 1 + len;
            r = l;
        }
        return liststr;
    }
}
