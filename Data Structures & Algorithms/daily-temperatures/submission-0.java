class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // monotonic dec stack
        int len = temperatures.length;
        int[] res = new int[len];
        // stack to store int array of pairs temp:index
        Stack<int[]> stack = new Stack<>();

        for (int i = 0; i < len; i++) {
            int temps = temperatures[i];

            // lets check if the element in stack is greated than current temps - pop pair and
            // update index diff, else push
            while (!stack.isEmpty() && temps > stack.peek()[0]) { // 74 - we found warmer day
                int[] pair = stack.pop();
                res[pair[1]] = i - pair[1];
            }
            // put airs temps and index
            stack.push(new int[] {temps, i}); // 73:0
        }
        return res;
    }
}
