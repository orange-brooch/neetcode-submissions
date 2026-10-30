class Solution {
    public int maxProfit(int[] prices) {
        // 2 pointer way - slow and fast pointer;

        int l = 0, r = 1, maxP = 0;

        while (r < prices.length) {
            if (prices[l] < prices[r]) {
                int profit = prices[r] - prices[l];
                maxP = Math.max(maxP, profit);
            } else {
                l = r;
            }
            r++;
        }
        return maxP;
    }
}
