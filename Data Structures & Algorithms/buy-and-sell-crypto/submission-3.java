class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        if (prices == null || prices.length == 0) {
            return 0;
        }
        // fast and slow pointers
        int l = 0, r = 1;
        // need to visit the array for all proces to determine
        while (r < prices.length) {
            // check if there is a profit
            if (prices[l] < prices[r]) {
                // calc profit
                int profit = prices[r] - prices[l];
                // since we have a new profit, recalc maxProfit
                maxProfit = Math.max(profit, maxProfit);
                
            } else {
                l = r;
            }
            
            r++;
        }
        return maxProfit;
    }
}
