class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
       
        Map<String, List<String>> result = new HashMap<>();

        for(String s : strs){ 
            char[] ch = s.toCharArray();
            Arrays.sort(ch); //act
            String sortedS = new String(ch);
            result.putIfAbsent(sortedS, new ArrayList<>());
            result.get(sortedS).add(s); //
        }
        return new ArrayList<>(result.values());
    }
}
