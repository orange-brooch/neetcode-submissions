class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // piles = [1,4,3,2], h = 9 - not sorted
        // min = 1 max is 4 - at rate of 4 - 4hrs; but we have 9hrs lets check slower options; at 3
        // 1211=5 valid ; at rate 2 - 1221 -  6 valid; at rate 1 1432 = 10 not valid; so rate 2 is
        // the first valid ans

        int l = 1, r = Arrays.stream(piles).max().orElse(0);

        while (l < r) {
            int mid = l + (r - l) / 2;
            if (timetaken(piles, mid) > h) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        return l;
    }

    private static int timetaken(int[] piles, int rate) {
        int timet = 0;
        for (int pile : piles) {
            timet += (pile + rate - 1) / rate;
        }
        return timet;
    }
}
