class Solution {
    public boolean isValid(String s) {
        // creare a dict of pairs close to open - stack

        Map<Character, Character> pair = new HashMap<>();
        pair.put('}', '{');
        pair.put(']', '[');
        pair.put(')', '(');
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && pair.containsKey(c)) {
                char open = stack.pop();
                if (pair.get(c) != open) {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.size() == 0;
    }
}
