class Solution {
    public String encode(List<String> strs) {
        // #hello#world - failes if there is another spl char
        //  so we had string length ahead of the word with a spl char
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s.length()).append('#').append(s);
        }
        return String.valueOf(sb);
    }

    public List<String> decode(String str) {
        // we use 2 pointers to read len spl char # and word
        List<String> res = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            int j = i;
            while (str.charAt(j) != '#') {
                j++;
            }
            int length = Integer.parseInt(str.substring(i, j));
            i = j + 1;
            j = length + i;
            res.add(str.substring(i, j));
            i = j;
        }
        return res;
    }
}
