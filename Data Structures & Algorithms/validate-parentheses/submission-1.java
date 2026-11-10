class Solution {
    public boolean isValid(String s) {
        // MAp of close to start
        Map<Character, Character> dict = new HashMap<>();
        dict.put('}', '{');
        dict.put(']', '[');
        dict.put(')', '(');
        Stack<Character> newstack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (!newstack.isEmpty() && dict.containsKey(ch)) {
                char match = newstack.pop();
                if (match != dict.get(ch)) {
                    return false;
                }
            } else {
                newstack.add(ch);
            }
        }
        return newstack.size() == 0;
    }
}
