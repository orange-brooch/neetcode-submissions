class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Input: strs = ["act","pots","tops","cat","stop","hat"]
        //  a c t - act,cat; pots - pots, tops, stop; hat
        // sort , if key match add to list
        // Output: [["hat"],["act", "cat"],["stop", "pots", "tops"]]

        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            String newString = new String(charArray);
            map.putIfAbsent(newString, new ArrayList<>());
            map.get(newString).add(s);
        }

        return new ArrayList<>(map.values());
    }
}
