class Solution {
    public boolean isAnagram(String s, String t) {

        Map<Character, Integer> mapS = new HashMap<>();
         Map<Character, Integer> mapT = new HashMap<>();


if(s.length() == t.length()){
    int len = s.length();

   for(int i = 0; i<len; i++){
        char cs = s.charAt(i);
        mapS.merge(cs, 1, Integer::sum);
        char ct = t.charAt(i);
        mapT.merge(ct, 1, Integer::sum);

        }
}
else{
    return false;
}
return mapS.equals(mapT);

    }
}
