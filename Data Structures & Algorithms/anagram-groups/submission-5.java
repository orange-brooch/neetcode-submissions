class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] charray = s.toCharArray();
            Arrays.sort(charray);
            String key = new String(charray);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(s);
        }
        return new  ArrayList<>(map.values());
    }
}
